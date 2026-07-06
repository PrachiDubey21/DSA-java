import java.util.*;

public class ReverseBit {

    public static int reverseBits(int n) {

        int ans = 0;

        for (int i = 0; i < 32; i++) {

            int bit = n & 1;
            ans = ans << 1;
            ans = ans | bit;
            n = n >>> 1;

        }

        return ans;
    }

    public static void main(String[] args) {

        int n = 5;

        System.out.println("Before = " + n);
        int reversed = reverseBits(n);
        System.out.println("After = " + reversed);

    }

}
