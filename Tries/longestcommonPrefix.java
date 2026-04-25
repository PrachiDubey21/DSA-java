public class longestcommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        // Edge case: empty or null array
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Assume first string is the prefix
        String prefix = strs[0];

        // Compare prefix with remaining strings
        for (int i = 1; i < strs.length; i++) {

            // Reduce prefix until it matches the start of current string
            while (!strs[i].startsWith(prefix)) {

                prefix = prefix.substring(0, prefix.length() - 1);

                // If prefix becomes empty, no common prefix exists
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    // Main method
    public static void main(String[] args) {

        String[] words = { "flower", "flow", "flight" };

        String result = longestCommonPrefix(words);

        System.out.println("Longest Common Prefix: " + result);
    }

}
