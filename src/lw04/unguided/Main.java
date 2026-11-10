package lw04.unguided;
import java.util.*;

public class Main {
    static void bubbleSort(int[] arr, int passes){
        for(int i=0; i<passes && i<arr.length-1; i++ ){
            for(int j=0; j<arr.length -1-i; j++){
                if(arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            
        }
    }

    static int binarySearch(int[] arr, int target){
        int low = 0;
        int high = arr.length-1;
        int steps = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            steps++;

            if(arr[mid] == target){
                return steps;
            }else if(target>arr[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return steps;
    }

    static int findIndex(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high){
            int mid = (low + high) / 2;

            if(arr[mid] == target){
                return mid;
            }else if(target > arr[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
       Scanner sc = new Scanner(Main.class.getResourceAsStream("parcels.txt"));

       int n = sc.nextInt();
       int[] parcels = new int[n];
       for(int i=0; i<n; i++){
        parcels[i] = sc.nextInt();
       }

       int m = sc.nextInt();
       int[] targets = new int[m];
       for(int i=0; i<m; i++){
        targets[i] = sc.nextInt();
       }

       sc.close();

       bubbleSort(parcels, 2);
       int[] twoPass = new int[n];

       for(int i=0; i<n; i++){
        twoPass[i] = parcels[i];
       }

       bubbleSort(parcels, n-1);
       System.out.println("==== After 2 Passes ====");
       for (int i = 0; i < n; i++) {
        System.out.print(twoPass[i]);
        if (i < n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

        System.out.println();
        System.out.println("==== Fully Sorted ====");

        for (int i = 0; i < n; i++){
            System.out.print(parcels[i]);

            if(i<n-1){
                System.out.print(" ");
            }
        }
        System.out.println();

        System.out.println();
        System.out.println("==== Search Results ====");

        for(int i=0; i<m; i++){
            int target = targets[i];
            int steps = binarySearch(parcels, target);
            int index = findIndex(parcels, target);

            if(index != -1){
                System.out.println(target + ": FOUND at index " + index + " (steps: " + steps + ")");
            }else{
                System.out.println(target + ": NOT FOUND (steps: " + steps + ")");
            }
        }

    }
}
