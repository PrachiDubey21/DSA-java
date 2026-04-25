import java.util.HashSet;

public class UnionIntersection {

    public static HashSet<Integer> union(int[] arr1, int[] arr2) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr1) {
            set.add(num);
        }

        for (int num : arr2) {
            set.add(num);
        }

        return set;
    }

    public static HashSet<Integer> intersection(int[] arr1, int[] arr2) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();

        for (int num : arr1) {
            set1.add(num);
        }

        for (int num : arr2) {
            if (set1.contains(num)) {
                result.add(num);
            }
        }

        return result;
    }

    // Main method to test
    public static void main(String[] args) {

        int[] arr1 = {7,3,9};
        int[] arr2 = {6,3,9,2,9,4 };

        System.out.println("Union: " + union(arr1, arr2));
        System.out.println("Intersection: " + intersection(arr1, arr2));
    }
}
