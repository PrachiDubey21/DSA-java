import java.util.*;

public class WordLadder {


    public static int wordLadder(String start, String target, Set<String> dict) {

        Queue<String> q = new LinkedList<>();
        q.add(start);

        int level = 1;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                String word = q.poll();

                if (word.equals(target)) {
                    return level;
                }

                // try all possible one-letter changes
                for (int j = 0; j < word.length(); j++) {

                    char[] arr = word.toCharArray();

                    for (char c = 'A'; c <= 'Z'; c++) {

                        arr[j] = c;
                        String newWord = new String(arr);

                        if (dict.contains(newWord)) {
                            q.add(newWord);
                            dict.remove(newWord); // avoid repeat
                        }
                    }
                }
            }

            level++;
        }

        return 0; // not found
    }

    public static void main(String[] args) {

        Set<String> dict = new HashSet<>(
            Arrays.asList("POON","PLEE","SAME","POIE","PLEA","PLIE","POIN")
        );

        String start = "TOON";
        String target = "PLEA";

        System.out.println(wordLadder(start, target, dict));
    }
    
}
