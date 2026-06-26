public class SubStringVowels {

    public static int maxVowels(String s, int k) {

        int count = 0;

        //Initial k letters checked
        for (int i = 0; i < k; i++) {

            char ch = s.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u') {
                count++;
            }
        }

        int maxCount = count;

        for (int i = k; i < s.length(); i++) {

            //minus left letter
            char left = s.charAt(i - k);

            if (left == 'a' || left == 'e' || left == 'i' ||
                left == 'o' || left == 'u') {
                count--;
            }

            //add right letter
            char right = s.charAt(i);

            if (right == 'a' || right == 'e' || right == 'i' ||
                right == 'o' || right == 'u') {
                count++;
            }

            if (count > maxCount) {
                maxCount = count;
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {

        String s = "abciiidef";
        int k = 3;

        int ans = maxVowels(s, k);
        System.out.println("Max Number Of Vowels : " + ans);

    }
    
}