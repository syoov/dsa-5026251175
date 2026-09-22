package lw01.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
    Scanner sc = new Scanner(Main.class.getResourceAsStream("washes.txt"));
    int washCount = sc.nextInt();
    WashService[] services = new WashService[washCount];

    for(int i=0; i<washCount; i++){
        String type = sc.next();
        String id = sc.next();
        int days = sc.nextInt();
        

        if (type.equals("CAR")){
            services[i] = new CarWash(id, days);
        } else if (type.equals("MOTORCYCLE")){
            services[i] = new MotorcycleWash(id, days);
        }
    }

    sc.close();

    for (WashService wash : services) {
        System.out.println(wash.getId() + "|" + wash.label() + "|" + wash.calculateCharge());
    }
}
}
