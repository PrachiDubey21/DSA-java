public class startsWith {

    static class Node {
        Node[] children = new Node[26];
        boolean isEnd;

        Node() {
            isEnd = false;
        }
    }

    static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }

    public static boolean startsWith(String prefix) {
        Node curr = root;

        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';

            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {

        insert("apple");
        insert("app");
        insert("mango");
        insert("man");

        System.out.println(startsWith("app")); // true
        System.out.println(startsWith("moon")); // false

    }
}
