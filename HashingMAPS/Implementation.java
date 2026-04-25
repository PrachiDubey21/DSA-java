import java.util.*;

public class Implementation {

    // generic type of parameters
    static class Hashmap<K, V> {

        private class node {
            K key;
            V value;

            public node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size = 0; // n
        private int N;
        private LinkedList<node> buckets[]; // N

        @SuppressWarnings("unchecked")
        public Hashmap() {
            this.N = 4;
            this.buckets = new LinkedList[4];

            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }

        }

        private int hashfunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int Searchinll(K key, int bi) {

            LinkedList<node> ll = buckets[bi];
            int di = 0;

            for (int i = 0; i < ll.size(); i++) {
                node n = ll.get(i);
                if (n.key.equals(key)) {
                    return di;
                }
                di++;
            }

            return -1;
        }

        @SuppressWarnings("unchecked")
        public void rehash() {

            // store old buckets
            LinkedList<node>[] oldBuckets = buckets;

            // double the size of bucket array
            N = N * 2;
            buckets = new LinkedList[N];

            // initialize new buckets
            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }

            // reset size
            size = 0;

            // reinsert all nodes into new buckets
            for (int i = 0; i < oldBuckets.length; i++) {
                LinkedList<node> ll = oldBuckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    node n = ll.get(j);
                    put(n.key, n.value); // rehashing happens here
                }
            }
        }

        public void put(K key, V value) {

            int bi = hashfunction(key);
            int di = Searchinll(key, bi);

            // if value already exists just update the value
            if (di != -1) {
                node n = buckets[bi].get(di);
                n.value = value;
            } else {
                buckets[bi].add(new node(key, value));
                size++;
            }

            double lambda = (double) size / N;

            double k = 2.0;
            if (lambda > k) {
                rehash();
            }
        }

        public boolean containsKey(K key) {

            int bi = hashfunction(key); // bucket index
            int di = Searchinll(key, bi); // data index inside linked list

            if (di != -1) {
                return true;
            } else {
                return false;
            }
        }

        public V get(K key) {

            int bi = hashfunction(key);
            int di = Searchinll(key, bi);

            if (di != -1) {
                node n = buckets[bi].get(di);
                return n.value;
            }

            return null;
        }

        public V remove(K key) {

            int bi = hashfunction(key);
            int di = Searchinll(key, bi);

            if (di != -1) {
                node n = buckets[bi].remove(di);
                size--;
                return n.value;
            }

            return null;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public ArrayList<K> keySet() {

            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0; i < buckets.length; i++) {
                LinkedList<node> ll = buckets[i];

                for (int j = 0; j < ll.size(); j++) {
                    node n = ll.get(j);
                    keys.add(n.key);
                }
            }

            return keys;
        }

    }

    public static void main(String[] args) {

        HashMap<String, Integer> hm = new HashMap<>();

        // unordered map
        hm.put("prachi", 1000);
        hm.put("aditi", 1000);
        hm.put("vikas", 500);
        hm.put("pratibha", 600);
        hm.put("prachi", 800);

        // duplicate key
        hm.put("prachi", 800);

        // Test size
        System.out.println("Size: " + hm.size());

        // Test get
        System.out.println("prachi -> " + hm.get("prachi"));
        System.out.println("vikas -> " + hm.get("vikas"));

        // Test containsKey
        System.out.println("Contains aditi? " + hm.containsKey("aditi"));
        System.out.println("Contains rahul? " + hm.containsKey("rahul"));

        // Test keySet
        System.out.println("Keys: " + hm.keySet());

        // Test remove
        System.out.println("Removed prachi: " + hm.remove("prachi"));

        // Final 
        System.out.println("Size after removal: " + hm.size());
        System.out.println("Final Keys: " + hm.keySet());

    }

}
