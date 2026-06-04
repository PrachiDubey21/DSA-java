import java.util.*;

public class TotalWavinessInRange {

    public static int totalWaviness(int num1, int num2) {

        int ans = 0;

        for(int num = num1; num <= num2; num++) {
            ans += waviness(num);
        }

        return ans;
    }

    public static int waviness(int num) {

        int count = 0;

        while(num >= 100) {

            int right = num % 10;          
            int middle = (num / 10) % 10; 
            int left = (num / 100) % 10;  

            if((middle > left && middle > right) ||
               (middle < left && middle < right)) {
                count++;
            }

            num /= 10;
        }

        return count;
    }

    public static void main(String[] args) {

        int num1 = 120;
        int num2 = 130;

        System.out.println(totalWaviness(num1, num2));
    
    }
    
}
