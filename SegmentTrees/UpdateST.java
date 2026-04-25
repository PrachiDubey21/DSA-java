public class UpdateST {

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
        build(arr, 2 * node + 1, start, mid);

        // Recursively build right subtree
        build(arr, 2 * node + 2, mid + 1, end);

        // Combine (sum)
        return tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    public static void update(int[] arr, int idx, int newVal, int n) {

        // Calculate difference
        int diff = newVal - arr[idx];

        // Update original array
        arr[idx] = newVal;

        // Call recursive update
        updateUtil(0, 0, n - 1, idx, diff);
    }

    public static void updateUtil(int i, int si, int sj, int idx, int diff) {

        // Index not in range : return
        if (idx < si || idx > sj) {
            return;
        }

        // If index is in range : update current node
        tree[i] = tree[i] + diff;

        // Check if not a leaf node
        if (si != sj) {
            int mid = (si + sj) / 2;

            updateUtil(2 * i + 1, si, mid, idx, diff);
            updateUtil(2 * i + 2, mid + 1, sj, idx, diff);
        }
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int n = arr.length;

        init(n);

        build(arr, 0, 0, n - 1);

        System.out.println();

        // Print first few elements of tree
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }

        System.out.println();
        System.out.println();

        int idx = 2;
        int newVal = 2;

        update(arr, idx, newVal, n);

        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }

        System.out.println();
        System.out.println();

    }
}
