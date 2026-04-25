public class LongestWordWithAllPrefixes {

    static class Node {
        Node[] children = new Node[26];
        boolean isEnd;
    }

    static Node root = new Node();
    static String ans = "";

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

    // DFS traversal
    public static void dfs(Node node, StringBuilder sb) {

        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null && node.children[i].isEnd) {

                sb.append((char) (i + 'a'));

                String currWord = sb.toString();

                if (currWord.length() > ans.length()) {
                    ans = currWord;
                }

                //recursion
               dfs(node.children[i], sb);

                // backtrack
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static String longestWord(String[] words) {

        if(root==null){
            return "";
        }

        for (String word : words) {
            insert(word);
        }

        dfs(root, new StringBuilder());
        return ans;
    }

    public static void main(String[] args) {

        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(longestWord(words));
    }
}
