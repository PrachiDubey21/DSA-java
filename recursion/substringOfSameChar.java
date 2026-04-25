//We are given a string S,
// we need to find the count of all contiguous substrings 
// starting and ending with the same character.

public class substringOfSameChar {

    public static int countPalSubseq(String str, int i, int j) {

        // Base Case 1: single character
        if (i == j) {
            return 1;
        }

        // Base Case 2: invalid range
        if (i > j) {
            return 0;
        }

        // STEP 1: count excluding left character
        int excludeLeft = countPalSubseq(str, i + 1, j);

        // STEP 2: count excluding right character
        int excludeRight = countPalSubseq(str, i, j - 1);

        // STEP 3: subtract the double counted middle part
        int removeOverlap = countPalSubseq(str, i + 1, j - 1);

        // Total until now
        int total = excludeLeft + excludeRight - removeOverlap;

        // STEP 4: If characters match → add 1 more palindrome
        if (str.charAt(i) == str.charAt(j)) {
            total += 1;
        }

        return total;
    }

    public static void main(String[] args) {
        String str = "abcab";
        int result = countPalSubseq(str, 0, str.length() - 1);
        System.out.println(result);
    }

}
