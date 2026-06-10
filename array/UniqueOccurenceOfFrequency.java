import java.util.*;

public class UniqueOccurenceOfFrequency {

    public static boolean uniqueOccurrences(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int freq : map.values()) {
            set.add(freq);
        }

        if (map.size() == set.size()) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter values ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean ans = uniqueOccurrences(arr);

        System.out.println(ans);

        sc.close();
    }
    
}
