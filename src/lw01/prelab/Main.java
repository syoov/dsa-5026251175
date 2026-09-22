package lw01.prelab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
        List<PrintJob> jobs = new ArrayList<>();

        Scanner sc = new Scanner(Main.class.getResourceAsStream("jobs.txt"));

        while(sc.hasNext()){
            String type = sc.next();
            String id = sc.next();
            int pages = sc.nextInt();

            PrintJob job;

            if(type.equals("MONO")){
                job = new Monoprint(id, pages);
            } else {
                job = new Colourprint(id, pages);
            }

            jobs.add(job);
        }

        sc.close();

        for (PrintJob job : jobs) {
            System.out.println(job.summary());
        }
 
       /* try (Scanner scanner = new Scanner(new File("jobs.txt"))) {
            while (scanner.hasNext()) {
                String type = scanner.next();
                String id = scanner.next();
                int pages = scanner.nextInt();
 
                if (type.equalsIgnoreCase("MONO")) {
                    jobs.add(new Monoprint(id, pages));
                } else if (type.equalsIgnoreCase("COLOUR")) {
                    jobs.add(new Colourprint(id, pages));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("jobs.txt tidak ditemukan");
            return;
        }
 
        for (PrintJob job : jobs) {
            System.out.println(job.summary());
        } */
    }
}
 