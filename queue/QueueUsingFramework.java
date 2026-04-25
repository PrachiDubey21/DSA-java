
import java.util.*;

public class QueueUsingFramework {

    public static void main(String[] args) {

        //queue is an interface here that is why
        // we cant create an object of queue
        // we create object of the classes that implements it

        //linkedlist and Arraydeque

        Queue<Integer> q = new LinkedList<>();

        q.add(10);
        q.add(20);
        q.add(30);

        System.out.println("Queue: " + q); // prints whole queue

        System.out.println("Peek: " + q.peek()); // front element
        System.out.println("Remove: " + q.remove()); // removes front

        System.out.println("Queue after remove: " + q);
    }

}
