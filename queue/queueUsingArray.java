public class queueUsingArray {

    static class Queue {
        int arr[]; // array to store queue
        int size; // max size
        int front; // index of front element
        int rear; // index of rear element

        // constructor
        Queue(int size) {
            arr = new int[size];
            this.size = size;
            front = -1;
            rear = -1;
        }

        // check if empty
        public boolean isEmpty() {
            return front == -1 && rear == -1;
        }

        // check if full
        public boolean isFull() {
            return rear == size - 1;
        }

        // add element (enqueue)
        public void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }

            if (front == -1) {
                front = 0; // first element
            }

            rear++;
            arr[rear] = data;
        }

        // remove element (dequeue)
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int result = arr[front];

            // if only one element
            if (front == rear) {
                front = rear = -1;
            } else {
                front++;
            }

            return result;
        }

        //takes 0(n);
        public int remove2(){

              if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            
            int front = arr[0];
            for(int i=0;i<rear;i++){
                arr[i] = arr[i+1];
            }
            rear--;
            return front;

        }


        // peek element (front)
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

            System.out.print("Queue: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        
        Queue q = new Queue(5);

        q.add(10);
        q.add(20);
        q.add(30);

        q.printQueue(); // ➜ Queue: 10 20 30

        q.remove2();
        q.printQueue(); // ➜ Queue: 20 30

        q.add(40);
        q.add(50);
        q.printQueue(); // ➜ Queue: 20 30 40 50

        System.out.println("Peek: " + q.peek());

        System.out.println(q.remove2());
        System.out.println(q.remove2());
        System.out.println(q.remove2());

        System.out.println("Empty? " + q.isEmpty());
    }

}
