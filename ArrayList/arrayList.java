import java.util.ArrayList;
import java.util.Collections;

public class arrayList {

    // array list gets its size double(can be .5 times , 1.5 times)
    // everytime
    // it gets filled and copies the element in it
    
    public static void main(String[] args) {

        System.out.println();

        // java collection framework
        ArrayList<Integer> list = new ArrayList<>();

        // add element o(1)
        list.add(23);
        list.add(2);
        list.add(3);
        list.add(32);

        System.out.println(list);
        System.out.println();

        // get element 0(1)
        System.out.println(list.get(2));
        System.out.println();

        // remove element o(n)
        list.remove(2);
        System.out.println(list);
        System.out.println();

        // set/change element at index O(n)
        list.set(2, 34);
        System.out.println(list);
        System.out.println();

        // add at index O(n)
        list.add(3, 45);
        System.out.println(list);
        System.out.println();

        // contains element O(n)
        System.out.println(list.contains(2));
        System.out.println(list.contains(3));
        System.out.println();

        // size
        System.out.println("Size is " + list.size());
        System.out.println();

        // print
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        System.out.println();

        // reverse
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        System.out.println();

        // maximum
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            // if(list.get(i) > max){
            // max=list.get(i);
            // }
            max = Math.max(max, list.get(i));
        }
        System.out.println("Maximum is : " + max);
        System.out.println();

        // swap
        int i = 1;
        int j = 3;
        System.out.println(list);
        int temp = list.get(i);
        list.set(i, list.get(3));
        list.set(j, temp);
        System.out.println(list);
        System.out.println();

        // sort
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        System.out.println();

        System.out.println(list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
        System.out.println();

    }

}
