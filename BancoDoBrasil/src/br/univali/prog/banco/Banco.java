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
public class Banco {
    private ContaCorrente[] contas;
    private int numeroAtual = 1000;
    private static int MAX_CONTAS = 9999;

    public Banco() {
        contas = new ContaCorrente[MAX_CONTAS];
    }
    
    
    
    
    public int criarConta(boolean especial,
            double saldo,
            double limite){
        int numero = obterNumeroConta();
        ContaCorrente nova = new ContaCorrente(especial, limite, numero, saldo);
        for(int x=0; x < MAX_CONTAS; x++) {
            if (contas[x] == null){
                contas[x] = nova;
                break;
            }
        }
        
        return numero;
    }
    
    public boolean depositar(int numeroConta, double valor){
        ContaCorrente conta = localizarConta(numeroConta);
        if (conta != null) {
            return conta.depositar(valor);
        }
        return false;
    }

    public boolean sacar(int numeroConta, double valor){
        ContaCorrente conta = localizarConta(numeroConta);
        if (conta != null) {
            return conta.sacar(valor);
        }
        return false;
    }
    
    public boolean transferir(int origem, int destino, double valor){
        ContaCorrente contaOrigem = localizarConta(origem);
        ContaCorrente contaDestino = localizarConta(destino);
        if (contaOrigem != null && contaDestino != null){
            if (contaOrigem.sacar(valor)) {
                return contaDestino.depositar(valor);
            }
            return false;
        }
        return false;
    }
    
    public String imprimirExtrato(int numeroConta){
        ContaCorrente conta = localizarConta(numeroConta);
        String extrato = "Extrato da conta "+numeroConta;
        for (Movimentacao movimentacao:conta.movimentacoes){
            if (movimentacao == null) {
                break;
            }
            extrato += "\n"+movimentacao.extrato();
        }
        extrato += "\n Saldo final R$"+conta.getSaldoAtual();
        return extrato;
    }
    
    private int obterNumeroConta() {
        return numeroAtual++;
    }
    
    private ContaCorrente localizarConta(int numero) {
        for(ContaCorrente conta:contas) {
            if (conta != null && conta.getNumeroConta() == numero){
                return conta;
            }
        }
        return null;
    }
    
}
