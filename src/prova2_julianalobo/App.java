/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prova2_julianalobo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Juliana
 */
public class App {

    /**
     * @param args the command line arguments
     * @throws prova2_julianalobo.Restricoes
     */
    public static void main(String[] args) throws Restricoes {
        Transacao transacao = new Transacao();
        Cliente cliente = new Cliente("Juliana", "08803671641");
        Conta conta = new Conta(369458, cliente, 1000.0f);

        float saldoAnterior = conta.getSaldo();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2021);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 24);

        transacao.realizarTransacao(cal.getTime(), conta, 1000.0f, "Depósito .", Movimento.DEPOSITAR);
        transacao.realizarTransacao(cal.getTime(), conta, 50.0f, "Pagamento boleto.", Movimento.SACAR);
        transacao.realizarTransacao(cal.getTime(), conta, 120.0f, "Pagamento boleto.", Movimento.SACAR);
        transacao.realizarTransacao(cal.getTime(), conta, 850.0f, "Depósito.", Movimento.DEPOSITAR);

        Map<String,String> usuarios = new HashMap<>();
        
        usuarios.put("topdown", "123");
        usuarios.put("juliana", "123");
        usuarios.put("maria", "123");

        System.out.println("Deseja exibir o relatório? (s/n)");
        
        Scanner scanner = new Scanner(System.in);
        String resposta = scanner.nextLine();

        if (resposta.equalsIgnoreCase("S")) {
            System.out.println("Digite o usuário:");
            String usuario = scanner.nextLine();
            System.out.println("Digite a senha:");
            String senha = scanner.nextLine();

            boolean usuarioValido = false;
            // Tentativa de iterar o hashmap mas não consegui fazer funcionar então deixei só a lógica depois de validar o usuário
            
            if (usuarioValido==true) {
                System.out.println("Emitindo Extrato da Conta Comum Número: " + conta.getNumero() + "\nCorrentista: "
                        + conta.getCorrentista().getNome() + "\nSaldo anterior: " + saldoAnterior);
                System.out.println("____________________");
                for (Movimento m : transacao.getMovimentos()) {
                    String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(m.getData());
                    String operacao = m.getOperacao() == Movimento.DEPOSITAR ? "Depósito" : "Saque";
                    System.out.println("Data: " + dataFormatada + "\nHistórico: " + m.getHistorico() + "\nValor: "
                            + m.getValor() + "\nOperação: " + operacao);
                    System.out.println("__________________");
                }

                System.out.println("Saldo atual: " + conta.getSaldo());
                
            } else {
                throw new Restricoes("Usuário ou Senha Inválidos!");
            }
        } 
    }
    
}
