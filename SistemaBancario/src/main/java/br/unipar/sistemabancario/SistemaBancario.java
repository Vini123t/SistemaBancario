package br.unipar.sistemabancario;

/**
 *
 * @author vinid
 */
import java.util.Scanner;
import br.unipar.sistemabancario.model.ContaBancaria;

public class SistemaBancario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
            final int MAX_CONTAS = 1000000;
        
        
        ContaBancaria[] contas = new ContaBancaria[MAX_CONTAS];
        
        int numContas = 0; 
        
        boolean sair = false;
        
        while (!sair) {
            System.out.println("===== Sistema Bancário =====");
            System.out.println("1. Criar conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Consultar saldo");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    if (numContas < MAX_CONTAS) {
                        System.out.print("Número da conta: ");
                        int numeroConta = scanner.nextInt();
                        scanner.nextLine(); // limpar o buffer
                        
                        System.out.print("Nome do titular: ");
                        String nomeTitular = scanner.nextLine();
                        
                        System.out.print("Saldo inicial: ");
                        double saldoInicial = scanner.nextDouble();
                        
                        
                        contas[numContas] = new ContaBancaria(numeroConta, nomeTitular, saldoInicial);
                        numContas++;
                        
                        System.out.println("Conta criada com sucesso!");
                    } else {
                        System.out.println("Limite máximo de contas atingido!");
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

