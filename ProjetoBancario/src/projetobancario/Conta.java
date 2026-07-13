/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetobancario;

import java.util.ArrayList;

/**
 *
 * @author pc gamer
 */
public class Conta {

    public int accountNumber;
    protected String type;
    private String name;
    private double balance;
    private String cpf;
    private int password;
    private boolean status;
    private ArrayList<String> bankStatement = new ArrayList<>();

    public Conta(String name, String cpf, int password, String type) {
        this.name = name;
        this.cpf = cpf;
        this.balance = 0;
        this.password = password;

        if (openAccount(type)) {
            System.out.println("Conta criada com sucesso");
        } else {
            System.out.println("Tipo de conta digitada invalido!\nConta definida como Conta corrente por padrão");
            setType("CC");
            setBalance(50);
        }

    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(int number) {
        this.accountNumber = number;
    }

    public String getType() {
        return this.type;
    }

    private void setType(String type) {
        this.type = type;
    }

    public boolean getStatus() {
        return this.status;
    }

    private void setStatus(boolean status) {
        this.status = status;
    }

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCpf() {
        return this.cpf;
    }

    private void setCpf(String cpf) {
        this.cpf = cpf;
    }

    private int getPassword() {
        return this.password;
    }

    private void setPassword(int password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean openAccount(String type) {
        setStatus(true);
        setType(type);
        switch (type) {
            case "CC":
                setBalance(50);
                return true;

            case "CP":
                setBalance(150);
                setStatus(true);
                return true;

            default:
                return false;
        }

    }

    public String closeAccount() {
        String r = "";
        if (getBalance() > 0) {
            r = "Não é possivel fechar contas com dinheiro";
        } else if (getBalance() < 0) {
            r = "Conta em débito";
        } else {
            setStatus(false);
        }
        return r;
    }

    public void payMonthly() {
        float pay = 0;
        if (getType() == "CC") {
            pay = 12;
            this.bankStatement.add("Coprança de manutenção: " + pay);
        } else if (getType() == "CP") {
            pay = 20;
            this.bankStatement.add("Coprança de manutenção: " + pay);

        }
        setBalance(getBalance() - pay);

    }

    public String getAccount() {

        return String.format("\nNúmero da conta:" + getAccountNumber() + "\nNome de usuario: " + getName() + "\nCpf: " + getCpf() + "\nTipo de conta: " + getType()
                + "\nStatus da conta: " + getStatus() + "\nSaldo: R$ %.2f", getBalance());
    }

    public void getStatement() {

        for (String c : this.bankStatement) {
            System.out.println(c);
        }

    }

    public boolean login(String cpf, int password) {
        return getCpf().equals(cpf) && getPassword() == password;
    }

    public String deposit(float money) {
        String r;
        if (getStatus()) {
            if (money > 0) {
                setBalance(getBalance() + money);
                r = "Depósito efetuado com sucesso!";
                this.bankStatement.add(String.format("Deposito: R$%.2f", money));

            } else {
                r = "Valor inserido invalido insira um valor maior que 0,00";
            }
        } else {
            r = "Impossível depositar";
        }

        return r;
    }

    public String withdrawMoney(float money) {
        String r;
        if (!getStatus()) {
            r = "Impossível sacar";
        } else if (getBalance() < money) {
            r = ("Saldo insuficiente!");
        } else if ((money <= getBalance()) && (money > 0)) {
            setBalance(getBalance() - money);
            r = "Saque efetuado com sucesso!";
            this.bankStatement.add(String.format("Saque: R$%.2f", money));

        } else {
            r = "Valor inserido invalido insira um valor maior que 0,00";
        }
        return r;
    }
}
