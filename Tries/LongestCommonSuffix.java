import java.util.*;

public class LongestCommonSuffix {

    public static void main(String[] args) {

        Solution sol = new Solution();

        String[] words = { "abcd", "bcd", "xbcd" };
        String[] query = { "cd", "bcd", "xyz" };

        int[] ans = sol.stringIndices(words, query);

        System.out.println(Arrays.toString(ans));
    }
}

class Solution {

    public int[] stringIndices(String[] words, String[] query) {

        Trie trie = new Trie();

        int index = -1;
        int smallest = Integer.MAX_VALUE;

        // Insert all words into trie
        for (int i = 0; i < words.length; i++) {

            trie.insert(words[i], i);

            // Find globally shortest word
            if (words[i].length() < smallest) {

                smallest = words[i].length();

                index = i;
            }
        }

        int[] ans = new int[query.length];

        // Process all queries
        for (int i = 0; i < query.length; i++) {

            int ind = trie.prefix(query[i]);

            // If no suffix match found
            if (ind == -1) {
                ans[i] = index;
            }

            else {
                ans[i] = ind;
            }
        }

        return ans;
    }
}

class TrieNode {

    int index;
    int len;

    TrieNode[] children;

    TrieNode() {

        index = -1;

        len = Integer.MAX_VALUE;

        children = new TrieNode[26];
    }
}

class Trie {

    TrieNode root;

    Trie() {

        root = new TrieNode();
    }

    // Insert word into trie
    void insert(String str, int ind) {

        TrieNode node = root;

        int strLen = str.length();

        // Traverse from RIGHT to LEFT
        for (int i = strLen - 1; i >= 0; i--) {

            int ch = str.charAt(i) - 'a';

            // Create node if absent
            if (node.children[ch] == null) {

                node.children[ch] = new TrieNode();
            }

            // Move ahead
            node = node.children[ch];

            // Store shortest word info
            if (strLen < node.len) {

                node.len = strLen;

                node.index = ind;
            }
        }
    }

    // Search longest suffix match
    int prefix(String query) {

        TrieNode node = root;

        int result = -1;

        // Traverse from RIGHT to LEFT
        for (int i = query.length() - 1; i >= 0; i--) {

            int ch = query.charAt(i) - 'a';

            // Path breaks
            if (node.children[ch] == null) {
                break;
            }

            node = node.children[ch];

            result = node.index;
        }

        return result;
    }

}
