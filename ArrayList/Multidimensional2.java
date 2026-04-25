import java.util.ArrayList;

public class Multidimensional2 {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> mainlist = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(4);
        list1.add(6);
        list1.add(8);
        mainlist.add(list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(6);
        list2.add(9);
        list2.add(12);
        mainlist.add(list2);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(4);
        list3.add(8);
        list3.add(12);
        list3.add(16);
        mainlist.add(list3);

        System.out.println();
        System.out.println("YOUR 2D ARRAYLIST IS : ");
        System.out.println();

        for (int i = 0; i < mainlist.size(); i++) {

            ArrayList<Integer> currlist = mainlist.get(i);

            for (int j = 0; j < currlist.size(); j++) {
                System.out.print(currlist.get(j) + " ");

            }
            System.out.println();
        }

    }

}
