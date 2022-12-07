/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova2_julianalobo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Juliana
 */
public class Transacao {
    private final List<Movimento> movimentos;

    public Transacao() {
        this.movimentos = new ArrayList<>();
    }

    public void realizarTransacao(Date data, Conta conta, float valor, String historico, int operacao) {
        Movimento movimento = new Movimento(data, conta, historico, valor, operacao);
        // Não consegui ajustar esse problema de tipos
        if (movimento.movimentar()) {
            this.movimentos.add(movimento);
        } 
    }

    public void estornarTransacao() {
        for (Movimento movimento : this.movimentos) {
            if (movimento != null) {
                movimento = null;
            }
        }
    }
    public List<Movimento> getMovimentos() {
        return this.movimentos;
    }
}
