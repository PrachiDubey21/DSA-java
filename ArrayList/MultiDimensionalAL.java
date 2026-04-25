import java.util.ArrayList;

public class MultiDimensionalAL {

    public static void main(String[] args) {

        // create outer ArrayList
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        // create 3 rows
        for (int i = 0; i < 3; i++) {
            list.add(new ArrayList<>());
        }

        // add elements
        list.get(0).add(1);
        list.get(0).add(2);

        list.get(1).add(3);
        list.get(1).add(4);

        list.get(2).add(5);
        list.get(2).add(6);

        // print 2D ArrayList
        System.out.println("2D ArrayList Output:");
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}
