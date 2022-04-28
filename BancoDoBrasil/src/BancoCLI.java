
import br.univali.prog.banco.Banco;
import br.univali.prog.banco.ContaCorrente;
import static java.lang.Integer.parseInt;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1978233
 */
public class BancoCLI {
    
    private Banco banco;

    public BancoCLI() {
        banco = new Banco();
        mostrarMenu();
    }
    
    private String lerValor(String rotulo){
        System.out.print(rotulo+":");
        Scanner leitor = new Scanner(System.in);
        return leitor.nextLine();
    }
    
    public void mostrarMenu(){
        
        String opcoes = "Menu principal do banco";
        opcoes += "\n 1 - criar conta";
        opcoes += "\n 2 - depositar";
        opcoes += "\n 3 - sacar";
        opcoes += "\n 4 - transferir";
        opcoes += "\n 5 - finalizar";
        
        char opcao;
        do {
            System.out.println(opcoes);
            opcao = this.lerValor("Escolha uma opcao").charAt(0);
            switch (opcao) {
                case '1': this.criarConta();break;
                case '2': this.depositar();break;
                case '3': this.sacar(); break;
                case '4': this.transferir();break;
            }
        } while (opcao != '5');
        
    }
    
    public void criarConta(){
        System.out.println("Criação de conta");
        boolean especial = this.lerValor("Conta especial [s/n]").charAt(0) == 's';
        double saldoInicial = Double.parseDouble(this.lerValor("Digite o saldo Inicial"));
        double limite = 0;
        if (especial){
            limite = Double.parseDouble(this.lerValor("Digite o limite"));
        }
        this.banco.criarConta(especial, saldoInicial, limite);
    }
    
    public void depositar() {
        System.out.println("Depositar");
        int numero = parseInt(this.lerValor("Digite a conta Destino:"));
        double valor = Double.parseDouble(this.lerValor("Valor a ser depositado:"));
        this.banco.depositar(numero, valor);
        
        
        
    }
    
    public void sacar() {
        System.out.println("Sacar");
        int numero = parseInt(this.lerValor("Numero da conta destino:"));
        double valor = Double.parseDouble(this.lerValor("Valor a ser sacado:"));
        this.banco.sacar(numero, valor);
    }
    
    public void transferir() {
        System.out.println("Transferir");
        int origem = parseInt(this.lerValor("Conta de origem:"));
        int destino = parseInt(this.lerValor("Conta destino:"));
        double valor = Double.parseDouble(this.lerValor("Valor a ser transferido:"));
        this.banco.transferir(origem, destino, valor);
        
    }
    
}
