public class queueUsingLL {

    // Node structure
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        Node front;
        Node rear;

        Queue() {
            this.front = null;
            this.rear = null;
        }

        // Check if empty
        public boolean isEmpty() {
            return front == null && rear == null;
        }

        // Add element (enqueue)
        public void add(int data) {
            Node newNode = new Node(data);

            if (rear == null) {
                // queue empty
                front = rear = newNode;
                return;
            }

            rear.next = newNode;  // attach new node at end
            rear = newNode;        // update rear
        }

        // Remove element (dequeue)
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int val = front.data;

            // If only one element
            if (front == rear) {
                front = rear = null;
            } else {
                front = front.next;
            }

            return val;
        }

        // Peek front element
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return front.data;
        }

        // Print Queue
        public void printQueue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }

            Node temp = front;
            System.out.print("Queue: ");

            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    // Main
    public static void main(String[] args) {

        Queue q = new Queue();

        q.add(10);
        q.add(20);
        q.add(30);

        q.printQueue();  // Queue: 10 20 30

        System.out.println("Removed: " + q.remove());
        q.printQueue();  // Queue: 20 30

        q.add(40);
        q.add(50);

        q.printQueue();  // Queue: 20 30 40 50

        System.out.println("Peek: " + q.peek());
    }
}

    

