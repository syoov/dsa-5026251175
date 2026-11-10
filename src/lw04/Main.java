package lw04;
import java.util.*;

public class Main {
    public static void main (String[] args) throws Exception {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));

        int n = sc.nextInt();
        int[] branches = new int[n];

        for(int i=0; i<n; i++){
            branches[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] targets = new int[m];

        for(int i=0; i<m; i++){
            targets[i] = sc.nextInt();
        }

        sc.close();

        selectionSort(branches, 3);

        for(int i=0; i<n; i++){
            System.out.println(branches[i]);
            if(i<n-1){
                System.out.print(" ");
            }
        }
        System.out.println();

        for(int i=0; i<m; i++){
            int index = linearSearch(branches, targets[i]);
            if(index != -1){
                System.out.println(targets[i] + ": FOUND at index " + index);
            } else {
                System.out.println(targets[i] + ": NOT FOUND");
            }
        }
    }

    public static void selectionSort(int[] arr, int passes) {
        int n = arr.length;

        for(int i=0; i<passes; i++){

            int maxIndex = i;
            for(int j=i+1; j<n; j++){
                if(arr[j]>arr[maxIndex]){
                    maxIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }

    public static int linearSearch(int[] arr, int target) {

        for(int i=0; i<arr.length; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }    
}
