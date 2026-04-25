import java.util.*;

public class MyDeque {

    int[] arr;
    int front, rear, size;

    public MyDeque(int size) {
        arr = new int[size];
        this.size = size;
        front = -1;
        rear = -1;
    }

    // Insert at front
    public void insertFront(int x) {
        if (isFull()) {
            System.out.println("Deque is full");
            return;
        }

        if (front == -1) { // first element
            front = rear = 0;
        } else if (front == 0) {
            front = size - 1; // wrap
        } else {
            front--;
        }
        arr[front] = x;
    }

    // Insert at rear
    public void insertRear(int x) {
        if (isFull()) {
            System.out.println("Deque is full");
            return;
        }

        if (front == -1) { // first element
            front = rear = 0;
        } else if (rear == size - 1) {
            rear = 0; // wrap
        } else {
            rear++;
        }
        arr[rear] = x;
    }

    // Delete from front
    public int deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }

        int value = arr[front];

        if (front == rear) { // only 1 element
            front = rear = -1;
        } else if (front == size - 1) {
            front = 0; // wrap
        } else {
            front++;
        }
        return value;
    }

    // Delete from rear
    public int deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }

        int value = arr[rear];

        if (front == rear) { // only 1 element
            front = rear = -1;
        } else if (rear == 0) {
            rear = size - 1; // wrap
        } else {
            rear--;
        }
        return value;
    }

    // Get first element
    public int getFirst() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        return arr[front];
    }

    // Get last element
    public int getLast() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        return arr[rear];
    }

    // Check if full
    public boolean isFull() {
        return (front == 0 && rear == size - 1) || (front == rear + 1);
    }

    // Check if empty
    public boolean isEmpty() {
        return front == -1;
    }

    // Display deque
    public void display() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return;
        }

        System.out.print("Deque: ");
        int i = front;

        while (i != rear) {
            System.out.print(arr[i] + " ");
            i = (i + 1) % size;
        }
        System.out.println(arr[rear]);
    }

    public static void main(String[] args) {

        MyDeque dq = new MyDeque(5);

        dq.insertRear(10);
        dq.insertRear(20);
        dq.insertFront(5);
        dq.insertFront(2);

        dq.display();

        // Check isEmpty and isFull
        System.out.println("Is Empty? " + dq.isEmpty());
        System.out.println("Is Full? " + dq.isFull());

        System.out.println("First Element: " + dq.getFirst());
        System.out.println("Last Element: " + dq.getLast());

        System.out.println("Deleted Front: " + dq.deleteFront());
        System.out.println("Deleted Rear: " + dq.deleteRear());

        dq.display();

    }
}
