public class MaxElementQyery {

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
        return tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
    }

    public static int getMax(int i, int si, int sj,
            int qi, int qj) {

        // Non-overlapping
        if (qj <= si || sj <= qi) {
            return Integer.MIN_VALUE;
        }

        // Completely overlapping
        if (si >= qi && sj <= qj) {
            // return max of that range
            return tree[i];
        }

        // Partially overlapping
        int mid = (si + sj) / 2;

        int leftSum = getMax(2 * i + 1, si, mid, qi, qj);
        int rightSum = getMax(2 * i + 2, mid + 1, sj, qi, qj);

        return Math.max(leftSum, rightSum);
    }

    public static void update(int[] arr, int idx, int newVal, int n) {

        // Update original array
        arr[idx] = newVal;

        // Call recursive update
        updateUtil(0, 0, n - 1, idx, newVal);
    }

    public static void updateUtil(int i, int si, int sj, int idx, int newvalue) {

        // Index not in range : return
        if (idx < si || idx > sj) {
            return;
        }

        if (si == sj) {
            tree[i] = newvalue;
        }

        // Check if not a leaf node
        if (si != sj) {

            // If index is in range : update current node
            tree[i] = Math.max(tree[i], newvalue);

            int mid = (si + sj) / 2;

            updateUtil(2 * i + 1, si, mid, idx, newvalue);
            updateUtil(2 * i + 2, mid + 1, sj, idx, newvalue);
        }
    }

    public static void main(String[] args) {

        int[] arr = { 6, 8, -1, 2, 17, 1, 3, 2, 4 };
        int n = arr.length;

        init(n);

        build(arr, 0, 0, n - 1);

        // Print first few elements of tree
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
        System.out.println();

        // print range query
        System.out.println("maximum of range 5-6 is : " + getMax(0, 0, n - 1, 5, 6));

        System.out.println();

        // update
        update(arr, 2, 20, n);

        // print new tree
        System.out.println("new tree is :");

        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
        System.out.println();

    }

}
