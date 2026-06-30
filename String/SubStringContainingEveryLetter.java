import java.util.*;

public class SubStringContainingEveryLetter {

//     Once a window is valid,
// every larger window ending later is also valid.

// Formula
// n - right

// After counting, move left.
// left++
// because maybe another smaller valid window exists.

  public static int numberOfSubstrings(String s) {

        int n = s.length();
        int[] arr = new int[3];
        int left = 0;
        int count = 0;

        for(int right = 0 ; right < n ;right ++){

          int ch = s.charAt(right);
          arr[ch - 'a']++;

          while(arr[0] > 0 && arr[1] > 0 && arr[2] > 0){
             
             int ans = n - right;
             count = count + ans;

             char leftch = s.charAt(left);
             arr[leftch - 'a']--;

             left++;

          }

        }
        return count;
    }

    public static void main(String[] args) {

        String s = "abcabc";

        int answer = numberOfSubstrings(s);
        System.out.println("Answer = " + answer);

    }
    
}
