import java.util.*;

public class MinIndexSumOfCommonWord {

    public static String[] findRestaurant(String[] list1, String[] list2) {

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        ArrayList<String> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < list2.length; i++) {

            if (map.containsKey(list2[i])) {

                int sum = map.get(list2[i]) + i;

                if (sum < min) {

                    ans.clear();
                    ans.add(list2[i]);
                    min = sum;

                } else if (sum == min) {
                    ans.add(list2[i]);
                }
            }
        }

        return ans.toArray(new String[0]);
    }
    

 public static void main(String[] args) {

        String[] list1 = {
                "hehe",
                "helo",
                "awww",
                "nope"
        };

        String[] list2 = {
                "helo",
                "hehe",
                "Hieeeee",
                "nope"
        };

        String[] result = findRestaurant(list1, list2);
        System.out.println("minimum index sum:");

        for (String restaurant : result) {
            System.out.println(restaurant);
        }
    }
}