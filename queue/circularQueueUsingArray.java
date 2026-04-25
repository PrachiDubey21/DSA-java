public class circularQueueUsingArray {

    static class CircularQueue {
        int arr[];
        int size;
        int front;
        int rear;

        CircularQueue(int size) {
            this.size = size;
            arr = new int[size];
            front = -1;
            rear = -1;
        }

        // Check if empty
        public boolean isEmpty() {
            return front == -1;
        }

        // Check if full
        public boolean isFull() {
            return (rear + 1) % size == front;
        }

        // Add element
        public void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }

            if (front == -1) { // first element
                front = 0;
            }

            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // Remove element
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int value = arr[front];

            if (front == rear) {
                // only one element
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }

            return value;
        }

        // Peek front element
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }

        
        public void printQueue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }

            System.out.print("Circular Queue: ");

            int i = front;
            while (true) {
                System.out.print(arr[i] + " ");
                if (i == rear)
                    break;
                i = (i + 1) % size;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        CircularQueue q = new CircularQueue(5);

        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);

        q.printQueue(); // 10 20 30 40

        q.remove();
        q.remove();

        q.printQueue(); // 30 40

        q.add(50);
        q.add(60);
        q.add(70); // wraps around circularly

        q.printQueue(); // 30 40 50 60 70
    }
}
