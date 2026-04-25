import java.util.*;

public class Traversal {

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

        public static void PreOrder(Node root){

            if(root == null){
                return;
            }
            System.out.print(" data : " + root.data);
            PreOrder(root.left);
            PreOrder(root.right);

        }

         public static void InOrder(Node root){

            if(root == null){
                return;
            }
            InOrder(root.left);
            System.out.print(" data : " + root.data + " ");
            InOrder(root.right);

        }

         public static void PostOrder(Node root){

            if(root == null){
                return;
            }
            
            PostOrder(root.left);
            PostOrder(root.right);
            System.out.print(" data : " + root.data);

        }

        public static void LevelOrder(Node root){

            //we will use queue here
            //insert root into queue then remove it and print it
            //then add its children in queue
            //for next line we will add null

            if(root == null){
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node curr = q.remove();

                if(curr==null){

                    System.out.println();

                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{

                    System.out.print(curr.data  + " ");

                    if(curr.left != null){
                        q.add(curr.left);
                    }

                    if(curr.right != null){
                        q.add(curr.right);
                    }
                }
            }




        }
    }

    public static void main(String[] args){

        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println();

        System.out.println("PreOrder traversal : ");
        tree.PreOrder(root);
        System.out.println();
        System.out.println();

        System.out.println("InOrder traversal : ");
        tree.InOrder(root);
        System.out.println();
        System.out.println();

        System.out.println("PostOrder traversal : ");
        tree.PostOrder(root);
        System.out.println();
        System.out.println();

         System.out.println("LevelOrder traversal : ");
        tree.LevelOrder(root);
        System.out.println();
        System.out.println();


    }
    
}
