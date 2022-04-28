/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.prog.banco;

/**
 *
 * @author 1978233
 */
public class ContaCorrente {
    protected Movimentacao[] movimentacoes;
    private boolean especial;
    private double limite;
    private int numeroConta;
    private double saldo;

    public ContaCorrente(boolean especial, double limite, int numeroConta, double saldo) {
        this.especial = especial;
        this.limite = limite;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.movimentacoes = new Movimentacao[99999];
        criarMovimentacao("saldo inicial", saldo);
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldoAtual() {
        return saldo;
    }
    
    

    public boolean depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            criarMovimentacao("deposito", valor);
            return true;
        }
        return false;
    }

    public boolean sacar(double valor) {
        if (valor <= this.saldo+this.limite) {
            this.saldo -= valor;
            criarMovimentacao("saque", valor*-1);
            return true;
        }
        return false;
    }    
    
    private void criarMovimentacao(String descricao, double valor){
        Movimentacao movimentacao = new Movimentacao(descricao, valor);
        for (int x=0; x < 9999; x++){
            if (movimentacoes[x] == null){
                movimentacoes[x]=movimentacao;
                break;
            }
        }
    }
    
    
    
    
}
