package lw03.prelab;
import java.util.*;

public class Main {
    public static void main (String[] args) {
      Scanner sc = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
      //problem 1
      List<String> playlists = new ArrayList<>();
      
      while (sc.hasNext()){
        String line = sc.nextLine();
        String operation = line.substring(0, line.indexOf(" "));
        String details = line.substring(line.indexOf(" ") + 1);

        if(operation.equals("ADD")){
            String song = details;
            playlists.add(song);
        } else if (operation.equals("INSERT")) {
            int index = Integer.parseInt(details.substring(0, details.indexOf(" ")));
            String song = details.substring(details.indexOf(" ") + 1);
            playlists.add(song);
        } else {
            String song = details;
            if(playlists.contains(song)){
                playlists.remove(song);
            } 
        }
      }

      System.out.println("===== Problem 1 =====");
      System.out.println("Total Songs: " + playlists.size());

      int nomor = 1;

      for(String abc : playlists){
        System.out.println(nomor + ": " + abc);
        nomor++;
      }

      //problem 2
      Scanner sc2 = new Scanner(Main.class.getResourceAsStream("participants.txt"));

      Set<String> participants = new LinkedHashSet<>();

      int duplicate = 0;
      while (sc2.hasNext()){
        String name = sc2.next();

        if(participants.contains(name)){
            duplicate++;
        } else {
            participants.add(name);
        }
      }

      System.out.println("===== Problem 2 =====");
      System.out.println("Unique participants: " + participants.size());
      int num = 1;

      for(String zhang : participants){
        System.out.println(num + ". " + zhang);
        num++;
      }

      //problem 3
      Scanner sc3 = new Scanner(Main.class.getResourceAsStream("inventory.txt"));

      Map<String, Integer> inventory = new LinkedHashMap<>();

      int failed = 0;
      while(sc3.hasNext()){
        String line = sc3.nextLine(); 
        String[] parts = line.split(" ");

        String type = parts[0];
        String product = parts[1];
        int quantity = Integer.parseInt(parts[2]);

        if(type.equals("ADD")){
            if(inventory.containsKey(product)){
                inventory.put(product, inventory.get(product) + quantity);   
            } else {
                inventory.put(product, quantity);
            }
        } else {
            if(inventory.containsKey(product) && inventory.get(product) >= quantity){
                inventory.remove(product, inventory.get(product) - quantity);
            } else {
                failed++;
            }
        }

        System.out.println("===== Problem 3 =====");

        for(String products : inventory.keySet()){
            System.out.println(products + ":" + inventory.get(products));
        }
        System.out.println("Failed sales: " + failed);
      }
    }
    
}
