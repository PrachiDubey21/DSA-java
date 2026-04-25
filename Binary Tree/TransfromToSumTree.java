
import java.util.*;

public class TransfromToSumTree {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

     public static void PreOrder(Node root){

            if(root == null){
                return;
            }
            System.out.print(" data : " + root.data);
            PreOrder(root.left);
            PreOrder(root.right);

        }

        public static int transfrom(Node root){

            if(root == null){
                return 0;
            }

            int leftsum = transfrom(root.left );
            int rightsum = transfrom(root.right );

            int data = root.data;

            int a , b;

            if(root.left ==null){
                a = 0;
            }
            else{
                 a = root.left.data;
            }

            if(root.right ==null){
                b = 0;
            }
            else{
                 b = root.right.data;
            }
            root.data= a + leftsum+ b + rightsum;
            return data;

        }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("PreOrder traversal : ");
        PreOrder(root);
        System.out.println();
        System.out.println();

        transfrom(root );

        System.out.println("PreOrder traversal : ");
        PreOrder(root);
        System.out.println();
        System.out.println();

    }

}
