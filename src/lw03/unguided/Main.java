package lw03.unguided;
import java.util.*;

public class Main {
    public static void main (String[] args){
        Scanner sc = new Scanner(Main.class.getResourceAsStream("registrations.txt"));
        Scanner sc2 = new Scanner(Main.class.getResourceAsStream("checkins.txt"));

        Set<String> registered =  new LinkedHashSet<>();
        Set<String> checkedIn = new LinkedHashSet<>();
        List<String> hasil = new ArrayList<>();

        int rejected = 0;

        while(sc.hasNext()){
           String id = sc.next();
            registered.add(id);
        }

        while(sc2.hasNext()){
            String id2 = sc2.next();

            if(!registered.contains(id2)){
                hasil.add(id2 + ": Rejected (not registered)"); //karena not registered
                rejected++;
            } else if (checkedIn.contains(id2)) {
                hasil.add(id2 + ": Rejected (already checked in)");
                rejected++;
            }  else {
                checkedIn.add(id2);
                hasil.add(id2 + ": Checked in");
            }
        }

        System.out.println("===== Event Check-In Results =====");
        for(String result : hasil){
            System.out.println(result);
        }

        System.out.println(" ");
        System.out.println("===== Final Event Summary =====");
        System.out.println("Registered students: " + registered.size());
        System.out.println("Successful check-ins: " + checkedIn.size());
        System.out.println("Absent students: " + (registered.size() - checkedIn.size()));
         System.out.println("Rejected attempts: " + rejected);



    }
    
}
