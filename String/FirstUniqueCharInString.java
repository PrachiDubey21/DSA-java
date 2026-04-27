import java.util.*;

public class FirstUniqueCharInString {

    public static int firstUniqChar(String s) {

        int[] freq = new int[26]; // for lowercase letters

        // Step 1: count frequency
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Step 2: find first unique character
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        int result = firstUniqChar(s);

        if (result != -1) {
            System.out.println("First unique character index: " + result);
        } else {
            System.out.println("No unique character found");
        }

        sc.close();
    }
    
}
