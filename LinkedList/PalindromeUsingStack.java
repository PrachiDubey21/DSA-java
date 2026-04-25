import java.util.Stack;

public class PalindromeUsingStack {

    // Node structure
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to check palindrome
    public static boolean isPalindrome(Node head) {

        Stack<Integer> stack = new Stack<>();
        Node temp = head;

        // Step 1: Push all elements into stack
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        // Step 2: Compare stack elements with linked list
        temp = head;
        while (temp != null) {
            int top = stack.pop();

            if (temp.data != top) {
                return false;   // Not palindrome
            }

            temp = temp.next;
        }

        return true;  // Palindrome
    }

    // Main method for testing
    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);

        if (isPalindrome(head)) {
            System.out.println("Linked List is Palindrome");
        } else {
            System.out.println("Linked List is NOT Palindrome");
        }
    }
}

