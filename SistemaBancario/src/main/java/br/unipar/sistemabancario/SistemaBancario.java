package br.unipar.sistemabancario;

/**
 *
 * @author vinid
 */
import java.util.Scanner;
import br.unipar.sistemabancario.model.ContaBancaria;
import javax.swing.JOptionPane;

public class SistemaBancario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
            final int maximo_contas = 1000000;
        
        
        ContaBancaria[] contas = new ContaBancaria[maximo_contas];
        
        int numContas = 0; 
        
        String input;
        
        boolean sair = false;
        
        while (!sair) {
            input = JOptionPane.showInputDialog("===== Sistema Bancário ===== \n"
                    + "1. Criar conta\n"
                    + "2. Depositar\n"
                    + "3. Sacar\n"
                    + "4. Consultar saldo\n"
                    + "5. Sair\n"
                    + "Escolha uma opção: ");
          
            int opcao;
            
            opcao = Integer.parseInt(input);
            
            switch (opcao) {
                case 1:
                    if (numContas < maximo_contas) {
                        input = JOptionPane.showInputDialog("Número da conta: \n");
                        int numeroConta;
                        numeroConta = Integer.parseInt(input);
                        
                        String nomeTitular = JOptionPane.showInputDialog("Nome do titular: \n");
                        
                       input = JOptionPane.showInputDialog("Saldo inicial:   \n");
                        double saldoInicial;
                        saldoInicial = Double.parseDouble(input);
                        
                        
                        contas[numContas] = new ContaBancaria(numeroConta, nomeTitular, saldoInicial);
                        numContas++;
                        
                        JOptionPane.showMessageDialog(null,"Conta criada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null,"Limite máximo de contas atingido!");
                    }
                    break;
                    
                case 2:
                    System.out.print("Número da conta: ");
                    int numeroContaDeposito = scanner.nextInt();
                    System.out.print("Valor a depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    
                    boolean depositoEncontrado = false;
                    
                    
                    for (int i = 0; i < numContas; i++) {
                        if (contas[i].getNumeroConta() == numeroContaDeposito) {
                            contas[i].depositar(valorDeposito);
                            depositoEncontrado = true;
                            break;
                        }
                    }
                    
                    if (depositoEncontrado) {
                        System.out.println("Depósito realizado com sucesso!");
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;
                    
                case 3:
                    System.out.print("Número da conta: ");
                    int numeroContaSaque = scanner.nextInt();
                    System.out.print("Valor a sacar: ");
                    double valorSaque = scanner.nextDouble();
                    
                    boolean saqueEncontrado = false;
                    
                    
                    for (int i = 0; i < numContas; i++) {
                        if (contas[i].getNumeroConta() == numeroContaSaque) {
                            if (contas[i].sacar(valorSaque)) {
                                saqueEncontrado = true;
                                System.out.println("Saque realizado com sucesso!");
                            } else {
                                System.out.println("Saldo insuficiente para saque!");
                            }
                            break;
                        }
                    }
                    
                    if (!saqueEncontrado) {
                        System.out.println("Conta não encontrada!");
                    }
                    break;
                    
                case 4:
                    System.out.print("Número da conta: ");
                    int numeroContaConsulta = scanner.nextInt();
                    
                    boolean contaEncontrada = false;
                    
                  
                    for (int i = 0; i < numContas; i++) {
                        if (contas[i].getNumeroConta() == numeroContaConsulta) {
                            System.out.println("Saldo: " + contas[i].getSaldo());
                            contaEncontrada = true;
                            break;
                        }
                    }
                    
                    if (!contaEncontrada) {
                        System.out.println("Conta não encontrada!");
                    }
                    break;
                    
                case 5:
                    sair = true;
                    System.out.println("Saindo do sistema...");
                    break;
                    
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            
            System.out.println();
        }
        
        scanner.close();
    }
}

