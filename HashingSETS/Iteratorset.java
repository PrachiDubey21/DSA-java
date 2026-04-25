import java.util.*;

public class Iteratorset {

    public static void main(String[] args) {

        HashSet<String> set = new HashSet<>();

        set.add("Apple");
        set.add("Banana");
        set.add("Mango");

        Iterator it = set.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}
