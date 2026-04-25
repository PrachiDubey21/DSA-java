import java.util.*;

public class SumOfNodes {

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

    static class BinaryTree {

        static int index = -1;

        public static Node buildTree(int nodes[]) {

            index++;
            if (nodes[index] == -1) {
                return null;
            }

            Node newnode = new Node(nodes[index]);
            newnode.left = buildTree(nodes);
            newnode.right = buildTree(nodes);

            return newnode;

        }

        public static int Sum(Node root) {

            if (root == null) {
                return 0;
            }

            int leftsum = Sum(root.left);
            int rightsum = Sum(root.right);

            int totalcount = leftsum + rightsum + root.data;

            return totalcount;
        }
    }

    public static void main(String[] args) {

        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println();

        System.out.println("The total Sum of nodes are : " + tree.Sum(root));

    }

}
