public class KthLargestOdd {

    public static int kthLargestOdd(int L, int R, int K) {

        int largestOdd;
        int smallestOdd;

        // find largest odd
        if (R % 2 != 0) {
            largestOdd = R;
        } else {
            largestOdd = R - 1;
        }

        // find smallest odd
        if (L % 2 != 0) {
            smallestOdd = L;
        } else {
            smallestOdd = L + 1;
        }

        // if no odd numbers exist
        if (largestOdd < smallestOdd) {
            return 0;
        }

        // count odd numbers
        int count = ((largestOdd - smallestOdd) / 2) + 1;

        // if k is greater than count
        if (K > count) {
            return 0;
        }

        // kth largest odd
        return largestOdd - (K - 1) * 2;
    }

    public static void main(String[] args) {

        int L = -3, R = 3, K = 3;
        System.out.println(kthLargestOdd(L, R, K));

    }
}
