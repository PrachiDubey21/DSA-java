
import java.util.*;

public class FirstNonRepeatingCharInStream {

    // Separate Function
    public static void firstNonRepeating(String stream) {

        int[] freq = new int[26]; // frequency array
        Queue<Character> q = new LinkedList<>();

        for (char ch : stream.toCharArray()) {

            // Step 1: Increase frequency
            freq[ch - 'a']++;

            // Step 2: Add to queue
            q.add(ch);

            // Step 3: Remove repeating characters from the queue front
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }

            // Step 4: Print answer
            if (q.isEmpty()) {
                System.out.print("-1 ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
    }

    // MAIN FUNCTION
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the stream: ");
        String stream = sc.nextLine();

        firstNonRepeating(stream); // Call the separate function

        sc.close();
    }

}
