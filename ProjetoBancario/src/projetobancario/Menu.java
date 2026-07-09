/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetobancario;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pc gamer
 */
public class Menu {

    //Cria um objeto c1 da classe Conta
    private static ArrayList<Conta> accounts = new ArrayList<>();//Cria uma lista de array (que cresce conforme o nescessario)
    private static int totalAccounts = 0;
    private static Scanner input = new Scanner(System.in);
    
    public static boolean menu() {

        boolean running = true;
        System.out.println(" 1- Entrar na conta\n 2- Criar conta\n 0-Sair do app");
        int response = input.nextInt();
        switch (response) {
            case 0:
                System.out.println("Saindo do app");
                return false;

            case 1:
                login();
                break;
            case 2:
                createAccont();
                break;

            default:
                throw new AssertionError();
        }
        return running;
    }

    public static void accountMenu(Conta c2) {
        int choice = 0;
        float money = 0;
        
        do {

            System.out.println("\nDigite a opção de sua escolha.");
            System.out.println(" 1- Saque\n 2- Deposito\n 3- Consultar saldo\n 4- Dados da conta\n 5- Extrato\n 0-Sair da conta");
            choice = input.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Saindo da conta.");
                    return;

                case 1:
                    System.out.print("\nDigite o valor de saque (ex:0,00): R$");
                    money = input.nextFloat();
                    System.out.println(c2.withdrawMoney(money));
                    break;
                case 2:
                    System.out.print("\nDigite o valor de Depósito (ex:0,00): R$");
                    money = input.nextFloat();
                    System.out.println(c2.deposit(money));
                    break;
                case 3:
                    System.out.printf("\nSaldo atual: R$ %.2f\n", c2.getBalance());
                    break;
                case 4:
                    System.out.println(c2.getAccount());
                    break;
                case 5:
                    System.out.println("");
                    c2.getStatement();
                    System.out.printf("Saldo atual: R$ %.2f\n", c2.getBalance());
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }
        } while (choice != 0);
    }

    public static void createAccont() {
        Conta c1 = new Conta();

        input.nextLine();
        System.out.print("Digite o nome de usuário: ");
        String name = input.nextLine();
        System.out.print("Digite o cpf (ex:123.456.789-00): ");
        String cpf = input.nextLine();
        System.out.print("Digite a senha somente numeros: ");
        int password = Integer.parseInt(input.nextLine());
        c1.setAccount(name, cpf, password);
        accounts.add(c1);
        accountMenu(accounts.getLast());
    }

    private static void logar(String cpf, int password) {
        int i = 0;
        for (Conta account : accounts) {

            if (account.getCpf().equals(cpf)) {

                boolean status = (account.login(cpf, password)) ? true : false;
                if (status) {
                    System.out.println("\nLogado");

                    accountMenu(accounts.get(i));
                    return;
                } else {
                    System.out.println("Falha no login");

                }

            }
            i++;

        }
        System.out.println("Usuario não encontrado!\n");
    }

    public static void login() {
        input.nextLine();
        System.out.print("Digite o cpf (ex:123.456.789-00): ");
        String cpf = input.nextLine();

        System.out.print("Digite a senha somente numeros: ");
        int password = Integer.parseInt(input.nextLine());

        logar(cpf, password);

    }
}
