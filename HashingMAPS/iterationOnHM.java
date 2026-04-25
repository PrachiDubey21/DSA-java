import java.util.*;

public class iterationOnHM {

    public static void main(String[] args) {

        HashMap<String, Integer> hm = new HashMap<>();

        // unordered map
        hm.put("prachi", 1000);
        hm.put("aditi", 1000);
        hm.put("vikas", 500);
        hm.put("pratibha", 600);
        hm.put("prachi", 800);

        Set<String> keys = hm.keySet();
        //can also  use hm.entrySet(); // returns pairs

        System.out.println(keys);

        for (String k : keys) {
            System.out.println("key = " + k + " - value = " + hm.get(k));
        }

    }
}
