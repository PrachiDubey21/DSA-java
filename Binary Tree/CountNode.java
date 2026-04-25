import java.util.*;

public class CountNode {

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

        public static int count(Node root){

            if(root==null){
                return 0;
            }

            int leftnodes = count(root.left);
            int rightnodes = count(root.right);

            int totalcount = leftnodes + rightnodes + 1;

            return totalcount;
        }
    }

    public static void main(String[] args) {

        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println();

        System.out.println("the total number of nodes are : " + tree.count(root));



    }

}
