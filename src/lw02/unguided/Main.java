package lw02.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("orders.txt"));

        LinkedList<String[]> orders = new LinkedList<>();
        LinkedList<String[]> foods = new LinkedList<>(); // isinya foodStock
        LinkedList<String[]> drinks = new LinkedList<>(); // isinya drinkStock
        LinkedList<String[]> successes = new LinkedList<>();
        Queue<String[]> process = new LinkedList<>();
        Stack<String[]> failed = new Stack<>();

        while(sc.hasNext()){
            String[] order = new String[4];
            order[0] = sc.next(); // name
            order[1] = sc.next(); // food
            order[2] = sc.next(); // drink
            order[3] = sc.next(); // table number
            orders.add(order);
        }

        // foodStock
        String[] Bakso = {"Bakso", "2"};
        String[] Sate = {"Sate", "1"};
        String[] Soto = {"Soto", "2"};

        foods.add(Bakso);
        foods.add(Sate);
        foods.add(Soto);

        // drinkStock
        String[] EsTeh = {"EsTeh", "4"};
        String[] EsJeruk = {"EsJeruk", "2"};

        drinks.add(EsTeh);
        drinks.add(EsJeruk);

        process.addAll(orders);
        while(!process.isEmpty()){ //ga kosong
            String[] order = process.poll();

            String foodName = order[1];
            String drinkName = order[2];

            String[] food = null;
            String[] drink = null;

            if (!foodName.equals("-")) {
                for (String[] data : foods) {
                    if (data[0].equals(foodName)) {
                        food = data;
                        break;
                    }
                }
            }

            if (!drinkName.equals("-")) {
                for (String[] data : drinks) {
                    if (data[0].equals(drinkName)) {
                        drink = data;
                        break;
                    }
                }
            }

            boolean foodAvailable = true;
            boolean drinkAvailable = true;

            if (food != null) {
                int stock = Integer.parseInt(food[1]);

                if (stock <= 0) {
                    foodAvailable = false;
                }
            }


            if (drink != null) {
                int stock = Integer.parseInt(drink[1]);

                if (stock <= 0) {
                    drinkAvailable = false;
                }
            }


            if (foodAvailable && drinkAvailable) {

                if (food != null) {
                    int stockF = Integer.parseInt(food[1]);
                    stockF--;
                    food[1] = String.valueOf(stockF);
                }

                if (drink != null) {
                    int stockD = Integer.parseInt(drink[1]);
                    stockD--;
                    drink[1] = String.valueOf(stockD);
                }

                successes.add(order);

            } else {
                failed.push(order);
            }
        }

        //order
        System.out.println("=== Successfully Processed Orders ===");

        for (String[] order : successes) {
            System.out.println(
                order[0] + " " +
                order[1] + " " +
                order[2] + " " +
                order[3]
            );
        }

        //food
        System.out.println();
        System.out.println("=== Remaining Food Stock ===");

        for (String[] food : foods) {
            System.out.println(food[0] + " : " + food[1]);
        }

        //drink
        System.out.println();
        System.out.println("=== Remaining Drink Stock ===");

        for (String[] drink : drinks) {
            System.out.println(drink[0] + " : " + drink[1]);
        }

        //failed
        System.out.println();
        System.out.println("=== Failed Orders ===");

        while (!failed.isEmpty()) {
            String[] order = failed.pop();

            System.out.println(
                order[0] + " " +
                order[1] + " " +
                order[2] + " " +
                order[3]
            );
        }
        sc.close();
    }
}