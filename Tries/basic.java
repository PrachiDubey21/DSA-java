import java.util.*;

public class basic {

    static class Node {

        Node children[] = new Node[26];
        boolean eow = false;

        public Node() {

            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }

        }

    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';

            if (curr.children[index] == null) {
                return false;
            }

            curr = curr.children[index];
        }

        return curr.eow == true;
    }

    public static void main(String[] args) {

        String arr[] = { "the", "a", "there", "their", "any", "thee" };

        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }

        System.out.println("Words inserted successfully");
        System.out.println();

        System.out.println(search("their")); // true
        System.out.println(search("any")); // true
        System.out.println(search("an")); // false
        System.out.println(search("these")); // false

        System.out.println();

    }

}