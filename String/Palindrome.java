public class Palindrome {

    public static boolean valid(char ch) {
        // Check if the character is alphanumeric (letters or digits)
        return (ch >= 'a' && ch <= 'z') || 
        (ch >= 'A' && ch <= 'Z') ||
         (ch >= '0' && ch <= '9');
    }

    public static char toLowercase(char ch) {
        // Convert uppercase letters to lowercase
        if (ch >= 'A' && ch <= 'Z') {
            return (char) (ch + ('a' - 'A')); // Convert to lowercase
        }
        return ch; // Return the character unchanged 
        //if it’s already lowercase or not a letter
    }

    public static boolean checkPalindrome(String a) {

        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                 // keep only alphanumeric
                temp.append(Character.toLowerCase(ch)); 
                // convert to lowercase
            }
        }

        String str = temp.toString();
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {

                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String str = "Helleh";
        boolean ans = checkPalindrome(str);
        if (ans == true) {
            System.out.println("string is a palindrome ");
        } else {
            System.out.println("string is not a palindrome ");
        }

    }

}
