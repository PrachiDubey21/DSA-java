import java.util.*;

public class ShortestUniquePrefix {

    static class Node {
        Node[] children = new Node[26];
        int freq;         
        boolean eow;

        Node() {
            freq = 1;     
            eow = false;
        }
    }

    static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

          
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            else {
                curr.children[idx].freq++;
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static String findPrefix(String word) {
        Node curr = root;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            curr = curr.children[idx];

            ans.append(word.charAt(i));

            if (curr.freq == 1) {
                break;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String[] words = {"zebra", "dog", "duck", "dove"};

        for (String word : words) {
            insert(word);
        }

        for (String word : words) {
            System.out.println(word + " -> " + findPrefix(word));
        }
    }
}
