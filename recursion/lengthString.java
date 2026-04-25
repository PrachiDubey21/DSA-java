public class lengthString {
   

        // Recursive function to find the length of a string

        public static int length(String str) {

            // Base case: empty string has length 0
            if (str.length() == 0) {
                return 0;
            }

            // Recursive call: length of substring + 1
            return length(str.substring(1)) + 1;
        }

        public static void main(String[] args) {

            String str = "abcde";
            System.out.println(length(str)); // Output: 5

        }
    }


