import java.util.*;

public class MinDistance {

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

    public static Node lca(Node root, int n1, int n2) {

        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftans = lca(root.left, n1, n2);
        Node rightans = lca(root.right, n1, n2);

        if (rightans == null) {
            return leftans;
        }

        if (leftans == null) {
            return rightans;
        }

        return root;
    }

    public static int lcadist(Node root, int n) {

        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int left = lcadist(root.left, n);
        int right = lcadist(root.right, n);

        if (left == -1 && right == -1) {
            return -1;
        }
         else if (right == -1) {
            return left+1;
        } 
        else {
            return right+1;
        }

    }

    public static int distance(Node root, int n1, int n2) {
        Node lca = lca(root, n1, n2);

        int dist1 = lcadist(root, n1);
        int dist2 = lcadist(root, n2);

        return dist1 + dist2;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("the min distance between nodes is : " + distance(root, 4, 6));

    }

}
