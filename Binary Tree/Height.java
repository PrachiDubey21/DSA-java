import java.util.*;

public class Height {

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

        public static int height(Node root){

            if(root==null){
                return 0;
            }

            int leftht = height(root.left);
            int rightht = height(root.right);

            return (Math.max(leftht , rightht) + 1);
        }
}

    public static void main(String[] args){

        
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println();

        System.out.println("the height of this tree is : " + tree.height(root));

    }
    
}
