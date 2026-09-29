package lw02.prelab;

import java.util.*;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(Main.class.getResourceAsStream("transactions.txt")); 

       LinkedList<String[]> transactions = new LinkedList<String[]>();
       LinkedList<String[]> customers = new LinkedList<String[]>();
       Queue<String[]> process = new LinkedList<>();
       Stack<String[]> failed = new Stack<>();

       while(sc.hasNext()){
        String[] transaction = new String[3];
        transaction[0] = sc.next(); //name
        transaction[1] = sc.next(); //type
        transaction[2] = sc.next(); //amount
        transactions.add(transaction);
       }

       process.addAll(transactions); //aduh lupa ini buat apa ya
       while(!process.isEmpty()){ //ga kosong/ masih ada
        String[] transaction = process.poll();
        String name = transaction[0];
        String type = transaction[1];
        int amount = Integer.parseInt(transaction[2]);

        String[] customer = null;
        for(String[] data : customers){
            if(data[0].equals(name)){
                customer = data;
                break;
            } 
        }
        
        if(customer == null){
            customer = new String[2];
            customer[0] = name;
            customer[1] = "0";
            customers.add(customer);
        }
        //pelajari ttg yang if customer == null

        int balance = Integer.parseInt(customer[1]);
        if(type.equals("DEPOSIT")){
            balance += amount;
            customer[1] = String.valueOf(balance);
        } else {
            if(balance<amount){
                failed.push(transaction);
            } else {
                balance -= amount;
                customer[1] = String.valueOf(balance);
            }
        }


       }

        System.out.println("=== Final Balances ===");
        for(String[] customer : customers){
            System.out.println(customer[0] + ":" + customer[1]);
        }

        System.out.println("=== Failed Transactions ===");
        while(!failed.isEmpty()){
            String[] transaction = failed.pop();
            System.out.println(transaction[0] + " " + transaction[1] + " " + transaction[2]);
        }

        sc.close();
    }
    
    
}
