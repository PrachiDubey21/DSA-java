import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

 class CreateTreeFromDescriptions {

    public TreeNode createBinaryTree(int[][] descriptions) {

        HashMap<Integer, TreeNode> nodes = new HashMap<>();
        HashSet<Integer>  children = new HashSet<>();

        for (int[] arr : descriptions) {
            int parent = arr[0];
            int child = arr[1];
            int isLeft = arr[2];

            if (!nodes.containsKey(parent)) {
                nodes.put(parent, new TreeNode(parent));
            }

            if (!nodes.containsKey(child)) {
                nodes.put(child, new TreeNode(child));
            }

            TreeNode parentNode = nodes.get(parent);
            TreeNode childNode = nodes.get(child);

            if (isLeft == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

             children.add(child);
        }

        for (int[] arr : descriptions) {

            int parent = arr[0];

            if (!children.contains(parent)) {
                return nodes.get(parent);
            }
        }

        return null;
    }
}

public class Main {

    public static void preorder(TreeNode root) {

        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        int[][] descriptions = {
            {20, 15, 1},
            {20, 17, 0},
            {50, 20, 1},
            {50, 80, 0},
            {80, 19, 1}
        };

        CreateTreeFromDescriptions obj = new CreateTreeFromDescriptions();

        TreeNode root = obj.createBinaryTree(descriptions);

        preorder(root);
    }
    
}
