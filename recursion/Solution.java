
public class Solution {

    public static int length(String str) {

        // BASE CASE
        if (str.length() == 0) {
            return 0;
        }

        // recursive call: remove first character and count +1
        return 1 + length(str.substring(1));
    }

    public static void main(String[] args) {
        String str = "abcde";
        System.out.println(length(str)); // Output: 5
    }

}
