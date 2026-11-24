package lw06.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        String firstLn = sc.nextLine();
        String[] nums = firstLn.split(" ");
        BinarySearchTree bst = new BinarySearchTree();

        for (int i = 0; i < nums.length; i++) {
            int value = Integer.parseInt(nums[i]);
            bst.insert(value);

        }

        System.out.print("Preorder : ");
        bst.preOrder();

        System.out.print("Inorder : ");
        bst.inOrder();

        System.out.print("Postorder : ");
        bst.postOrder();

        int target = sc.nextInt();

        System.out.println("Search " + target + " : " + bst.search(target));
        System.out.println("Nodes : " + bst.countNodes());
        System.out.println("Leaves : " + bst.countLeaves());

        sc.close();
    }
    
}
