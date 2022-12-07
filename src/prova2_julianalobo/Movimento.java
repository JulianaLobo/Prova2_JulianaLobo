/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova2_julianalobo;

import java.util.Date;

/**
 *
 * @author Juliana
 */
public class Movimento {
    private Date data;
    private Conta conta;
    private String historico;
    private float valor;
    private int operacao;
    private float saldoAnterior;

    // Atributos estáticos
    public static final int SACAR = 0;
    public static final int DEPOSITAR = 1;

    // Construtor
    public Movimento(Date data, Conta conta, String historico, float valor, int operacao) {
        this.data = data;
        this.conta = conta;
        this.historico = historico;
        this.valor = valor;
        this.operacao = operacao;
    }

    // Getters e Setters
    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Conta getConta() {
        return this.conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public String getHistorico() {
        return this.historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public float getValor() {
        return this.valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getOperacao() {
        return this.operacao;
    }

    public void setOperacao(int operacao) {
        this.operacao = operacao;
    }

    public float getSaldoAnterior() {
        return this.saldoAnterior;
    }

    public void setSaldoAnterior(float saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public void movimentar() {
        this.saldoAnterior = this.conta.getSaldo();
        switch (this.operacao) {
            case Movimento.SACAR:
                this.conta.movimentar(this.valor, Movimento.SACAR);
            case Movimento.DEPOSITAR:
                this.conta.movimentar(this.valor, Movimento.DEPOSITAR);
        }
    }
}
