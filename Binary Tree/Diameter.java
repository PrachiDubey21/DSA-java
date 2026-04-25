public class Diameter {

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

        // approach 1
        public static int height(Node root) {

            if (root == null) {
                return 0;
            }

            int leftht = height(root.left);
            int rightht = height(root.right);

            return (Math.max(leftht, rightht) + 1);
        }

        public static int diameter(Node root) {

            if (root == null) {
                return 0;
            }

            int leftdiameter = diameter(root.left);
            int leftht = height(root.left);

            int rightdiameter = diameter(root.right);
            int rightht = height(root.right);

            int self = leftht + rightht + 1;

            int ans = Math.max(leftdiameter, rightdiameter);
            ans = Math.max(self, ans);

            return ans;
        }

        // approach 2
        // class info is used here

        static class info {
            int diam;
            int ht;

            public info(int d, int h) {
                this.diam = d;
                this.ht = h;
            }
        }

        public static info caldiam(Node root) {

            if (root == null) {
                return new info(0, 0);
            }

            info left = caldiam(root.left);
            info right = caldiam(root.right);

            int self = left.ht + right.ht + 1;
            int ans = Math.max(left.diam, right.diam);
            ans = Math.max(ans, self);
            int ht = Math.max(left.ht, right.ht) + 1;

            return new info(ans, ht);

        }

    }

    public static void main(String[] args) {

        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println();

        System.out.println("the diameter of tree is : " + tree.diameter(root));
        System.out.println();
        System.out.println("the diameter of tree is : " + tree.caldiam(root).diam);

    }

}
