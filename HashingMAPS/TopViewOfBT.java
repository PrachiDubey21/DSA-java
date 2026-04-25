import java.util.*;

public class TopViewOfBT {


    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Pair {
        TreeNode node;
        int hd;

        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(TreeNode root) {

        if (root == null) return;

        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {

            Pair curr = queue.poll();
            TreeNode node = curr.node;
            int hd = curr.hd;

            // ONLY store first occurrence
            if (!map.containsKey(hd)) {
                map.put(hd, node.val);
            }

            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }

            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        for (int val : map.values()) {
            System.out.print(val + " ");
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(25);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        topView(root);
    }
    
}
