import java.util.ArrayList;

public class ContainerWithMostWater {

    public static int store2(ArrayList<Integer> ht) {

         int maxwater = 0;

        int lp = 0;
        int rp = ht.size() - 1;

        while(lp<rp){

        int wd = rp - lp;
        int height = Math.min(ht.get(lp), ht.get(rp));
        int water = wd * height;

        maxwater = Math.max(water,maxwater);
        
         if (ht.get(lp) < ht.get(rp)) {
                lp++;
            } else {
                rp--;
            }

        }
        return maxwater;

    }

    public static int store(ArrayList<Integer> ht) {
        int maxwater = 0;

        for (int i = 0; i < ht.size(); i++) {
            for (int j = i + 1; j < ht.size(); j++) {
                int wd = j - i;
                int height = Math.min(ht.get(j), ht.get(i));
                int water = wd * height;
                if (water > maxwater) {
                    maxwater = water;
                }
            }
        }
        return maxwater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);

        // brute force
        System.out.println("Answer is : " + store(list));

        // 2 pointer approach
        System.out.println("Answer is : " + store2(list));

    }

}
