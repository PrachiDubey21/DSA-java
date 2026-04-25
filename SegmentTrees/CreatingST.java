public class CreatingST {

    static int[] tree;

    public static void init(int n) {
        tree = new int[4 * n];
    }

    public static int build(int[] arr, int node, int start, int end) {

        // Base case: leaf node
        if (start == end) {
            tree[node] = arr[start];
            return arr[start];
        }

        int mid = (start + end) / 2;

        // Recursively build left subtree
         build(arr, 2 * node+1, start, mid);

        // Recursively build right subtree
         build(arr, 2 * node + 2, mid + 1, end);

        // Combine (sum)
        return tree[node] = tree[2*node+1] + tree[2*node+2];
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int n = arr.length;

        init(n);

        build(arr, 0, 0, n - 1);

        // Print first few elements of tree
        for (int i = 0; i <tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
    }

}
