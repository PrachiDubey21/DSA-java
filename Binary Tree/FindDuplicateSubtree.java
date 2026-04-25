import java.util.*;

public class FindDuplicateSubtree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        Map<String, Integer> map = new HashMap<>();

        List<TreeNode> result = new ArrayList<>();

        serialize(root, map, result);

        return result;
    }

    public static String serialize(TreeNode root, 
        Map<String, Integer> map, List<TreeNode> result) {

        if (root == null)
            {
                return "#";
            } 

        String left = serialize(root.left, map, result);
        String right = serialize(root.right, map, result);

        String curr = root.val + "," + left + "," + right;

        map.put(curr, map.getOrDefault(curr, 0) + 1);

        if (map.get(curr) == 2) {
            result.add(root);
        }

        return curr;
    }

    public static void printResult(List<TreeNode> list) {

        for (TreeNode node : list) {
            System.out.print(node.val + " ");
        }

    }

    public static void main(String[] args) {

        // Build tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(3);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);

        List<TreeNode> duplicates = findDuplicateSubtrees(root);

        System.out.print("Duplicate subtree roots: ");
        printResult(duplicates);
        
    }

    
}
