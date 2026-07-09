/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetobancario;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author pc gamer
 */
public class Conta {

    private String name;
    private double balance = 0;
    private String cpf;
    private int password;
    private ArrayList<String> bankStatement = new ArrayList<>();

    public void setAccount(String name, String cpf, int password) {
        this.name = name;
        this.cpf = cpf;
        this.balance = 0;
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public String getCpf() {
        return this.cpf;
    }

    private int getPassword() {
        return this.password;
    }

    private String getName() {
        return this.name;
    }

    public String getAccount() {
        
        return String.format("\nNome de usuario: " + getName() + "\nCpf: " + getCpf() + "\nSaldo: R$ %.2f", getBalance());
    }

    public void getStatement() {

        for (String c : this.bankStatement) {
            System.out.println(c);
        }

    }

    public boolean login(String cpf, int password){
      return this.cpf.equals(cpf)&&this.password==password;
    }
    public String deposit(float money) {
        String r;
        if (money > 0) {
            this.balance += money;
            r = "Depósito efetuado com sucesso!";
            this.bankStatement.add(String.format("Deposito: R$%.2f", money));

        } else {
            r = "Valor inserido invalido insira um valor maior que 0,00";
        }

        return r;
    }

    public String withdrawMoney(float money) {
        String r;
        if (this.balance < money) {
            r = ("Saldo insuficiente!");
        } else if ((money <=this.balance) && (money > 0)) {
            this.balance -= money;
            r = "Saque efetuado com sucesso!";
            this.bankStatement.add(String.format("Saque: R$%.2f", money));

        } else {
            r = "Valor inserido invalido insira um valor maior que 0,00";
        }
        return r;
    }
}
