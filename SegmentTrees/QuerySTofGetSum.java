public class QuerySTofGetSum {

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

     public static int getSum(int i, int si , int sj , 
        int qi, int qj) {

        // Non-overlapping
        if (qj <= si || sj <= qi) {
            return 0;
        }

        // Completely overlapping
        if (si >= qi && sj <= qj) {
         //include in sum
            return tree[i];
        }

        // Partially overlapping
        int mid = (si + sj) / 2;

        int leftSum = getSum(2 * i +1 , si , mid, qi , qj);
        int rightSum = getSum(2 * i + 2, mid + 1, sj , qi , qj);

        return leftSum + rightSum;
    }


    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int n = arr.length;

        init(n);

        build(arr, 0, 0, n - 1);

        System.out.println();

        // Print first few elements of tree
        for (int i = 0; i <tree.length; i++) {
            System.out.print(tree[i] + " ");
        }

        System.out.println();
        System.out.println();

        System.out.println("Using the get query function ");

        System.out.println();

        // 2 to 5 (3+4+5+6 = 18)
        int qi = 2;
        int qj = 5;

        int result = getSum(0, 0, n - 1, qi , qj);

        System.out.println("Sum from index " + qi + " to " + qj + " is : " + result);
    
        System.out.println();

    }
    
}
