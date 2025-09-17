package com.fil.bankingapp;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BankClient {
    private int current = -1;
    private Scanner scanner = new Scanner(System.in);
    private boolean done = false;
    private Bank bank = new Bank();

    public void run() {
        scanner = new Scanner(System.in);
        while(!done){
            System.out.print("Enter command (0= quit, 1=new, 2=select, 3=deposit, 4=loan, 5=show, 6=interest): ");
            int cmd = scanner.nextInt();
            processCommand(cmd);
        }
    }

    private void processCommand(int cmd) {
        switch (cmd){
            case 0:
                quit();
                return;
            case 1:
                newAccount();
                return;
            case 2:
                select();
                return;
            case 3:
                deposit();
                return;
            case 4:
                authorizeLoan();
                return;
            case 5:
                showAll();
                return;
            case 6:
                addInterest();
                return;
        }
    }

    private void newAccount() {
        current = bank.newAccount();
        System.out.println("Your new account number is "
                + current);
    }

    private void select() {
        System.out.print("Enter acct#: ");
        current = scanner.nextInt();
        int balance = bank.getBalance(current);
        System.out.println("The balance of account "
                + current + " is " + balance);
    }

    private void deposit() {
        System.out.print("Enter deposit amt: ");
        int amt = scanner.nextInt();
        bank.deposit(current, amt);
    }

    private void authorizeLoan() {
        System.out.print("Enter loan amt: ");
        int loanamt = scanner.nextInt();
        if (bank.authorizeLoan(current, loanamt))
            System.out.println("Your loan is approved");
        else
            System.out.println("Your loan is denied");
    }

    private void showAll() {
        System.out.println(bank.toString());
    }
    private void addInterest() {
        bank.addInterest();
    }


    private void quit() {
        done = true;
        System.out.println("Goodbye!...");
    }
}
