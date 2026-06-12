import java.util.*;

public class SumZero {

    public static int[] sumZero(int n) {

        int[] ans = new int[n];

        int index = 0;

        if (n % 2 == 1) {
            ans[index] = 0;
            index++;
        }

        int num = 1;

        while (index < n) {

            ans[index] = num;
            index++;

            ans[index] = -num;
            index++;

            num++;
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int[] result = sumZero(n);

        System.out.println("Array:");

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        sc.close();
    }
    
}
