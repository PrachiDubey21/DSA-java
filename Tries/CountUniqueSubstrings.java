public class CountUniqueSubstrings {

    static class Node {
        Node[] children = new Node[26];
    }

    static Node root = new Node();
    static int count = 0;   

    public static void insert(String s) {
        Node curr = root;

        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
                count++;  
            }
            curr = curr.children[idx];
        }
    }

    public static int countUniqueSubstrings(String s) {

        for (int i = 0; i < s.length(); i++) {
            insert(s.substring(i));
        }

        //for null string
        return count + 1;
    }

    public static void main(String[] args) {
        String s = "ababa";
        System.out.println(countUniqueSubstrings(s));
    }
}
