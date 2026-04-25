import java.util.*;

public class hashmap {

    public static void main(String[] args) {

        HashMap<String, Integer> hm = new HashMap<>();

        // unordered map
        hm.put("prachi", 1000);
        hm.put("aditi", 1000);
        hm.put("vikas", 500);
        hm.put("pratibha", 600);
        hm.put("prachi", 800);

        System.out.println(hm);
        // System.out.println(hm.get("prachi"));
        // System.out.println(hm.containsKey("vikas"));

        // hm.put("preeti", 700);
        // System.out.println(hm);

        // hm.remove("preeti");
        // System.out.println(hm);

        System.out.println(hm.size());

        System.out.println(hm.isEmpty());

        // clear function
        hm.clear();
        System.out.println(hm.isEmpty());

        

    }
}
