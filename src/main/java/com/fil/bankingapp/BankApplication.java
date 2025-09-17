package com.fil.bankingapp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BankApplication {

    public static void main(String[] args){
        BankClient bankClient = new BankClient();
        bankClient.run();
    }

//    public void run() {
//        scanner = new Scanner(System.in);
//        while(!done){
//            System.out.print("Enter command (0= quit, 1=new, 2=select, 3=deposit, 4=loan, 5=show, 6=interest): ");
//            int cmd = scanner.nextInt();
//            processCommand(cmd);
//        }
//    }

//    private void processCommand(int cmd) {
//        switch (cmd){
//            case 0:
//                quit();
//                return;
//            case 1:
//                newAccount();
//                return;
//            case 2:
//                select();
//                return;
//            case 3:
//                deposit();
//                return;
//            case 4:
//                authorizeLoan();
//                return;
//            case 5:
//                showAll();
//                return;
//            case 6:
//                addInterest();
//                return;
//        }
//    }

//    private void addInterest() {
//        Set<Integer> accts = accounts.keySet();
//        for (int i: accts){
//            int balance = accounts.get(i);
//            int newbalance = (int) (balance * (1+ rate));
//            accounts.put(i, newbalance);
//        }
//    }
//
//    private void showAll() {
//        final Set<Integer> accts = accounts.keySet();
//        System.out.println("The bank has "+accts.size()+ " accounts");
//        for (int i: accts){
//            System.out.println("\tBank account "+i+ " : balance="+accounts.get(i));
//        }
//    }
//
//    private void authorizeLoan() {
//        System.out.print("Enter loan amount: ");
//        int loanAmount = scanner.nextInt();
//        int balance = accounts.get(current);
//        if(balance > loanAmount/2){
//            System.out.println("Your loan is approved");
//        }else{
//            System.out.println("Your loan is denied");
//        }
//    }
//
//    private void deposit() {
//        System.out.println("Enter the deposit amount: ");
//        int amt = scanner.nextInt();
//        int balance = accounts.get(current);
//        accounts.put(current, balance+amt);
//        System.out.println("Amount: "+amt+ " is deposited into account: "+current);
//    }
//
//    private void select() {
//        System.out.print("Enter the account#: ");
//        current = scanner.nextInt();
//        Integer balance = accounts.get(current);
//        System.out.println("The balance of account "+current+ " is "+balance);
//    }
//
//    private void newAccount() {
//        current = nextacct++;
//        accounts.put(current,0);
//        System.out.println("New account number is: "+current);
//    }
//
//    private void quit() {
//        done = true;
//        System.out.println("Goodbye!...");
//    }
}
