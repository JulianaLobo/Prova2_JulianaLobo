/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova2_julianalobo;

/**
 *
 * @author Juliana
 */
public class Conta {

    private int numero;
    private Cliente correntista;
    private float saldo;

    public Conta() {
        this.numero = 0;
        this.correntista = new Cliente();
        this.saldo = 0.0f;
    }

    public Conta(int numero, Cliente correntista, float saldo) {
        this.numero = numero;
        this.correntista = correntista;
        this.saldo = saldo;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getCorrentista() {
        return this.correntista;
    }

    public void setCorrentista(Cliente correntista) {
        this.correntista = correntista;
    }

    public float getSaldo() {
        return this.saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    // Métodos
    public void depositar(float valor) {
        this.saldo += valor;
    }

    public void sacar(float valor) throws Restricoes {
        if (this.saldo >= valor) {
            this.saldo -= valor;
        } else {
            throw new Restricoes("Saldo insuficiente!");
        }
    }

    public void movimentar(float valor, int operacao) {
        switch (operacao) {
            case Movimento.DEPOSITAR:
                this.depositar(valor);
            case Movimento.SACAR:
                try {
                    this.sacar(valor);
                } catch (Restricoes e) {
                    System.out.println(e.getMessage());
                }
        }
    }
}
