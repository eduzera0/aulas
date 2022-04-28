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
public class Movimentacao {
    
    protected String descricao;
    protected double valor;
    protected char tipo;

    public Movimentacao(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = valor > 0 ? 'C' : 'D';
    }
    
    public String extrato(){
        return this.descricao+" R$"+this.valor;
    }
    
    
    
}
