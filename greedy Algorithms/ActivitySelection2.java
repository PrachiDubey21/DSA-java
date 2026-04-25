import java.util.*;

public class ActivitySelection2 {

    
    // Separate function to count maximum activities
    static int maxActivities(int[] start, int[] end) {

          // what if we also need to sort the array?
        int act[][] = new int[start.length][3];

        for (int i = 0; i < start.length; i++) {
            //keep track of original array
            act[i][0] = i;
            act[i][1] = start[i];
            act[i][2] = end[i];
        }

        //sort this on the basis of 2 column 
        Arrays.sort(act , Comparator.comparingDouble(o -> o[2]));

        // store index
        ArrayList<Integer> arr = new ArrayList<>();


        int count = 1; // first activity always selected
        int lastEnd = act[0][2]; // store end time of last selected activity
        arr.add(act[0][0]);

        for (int i = 1; i < start.length; i++) {
            if (act[i][1] >= lastEnd) { // non-overlapping condition
                count++;
                arr.add(act[i][0]);
                lastEnd = act[i][2]; // update end time
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            System.out.print("A" + arr.get(i) + " ");
        }
        System.out.println();

        return count;
    }

    public static void main(String[] args) {

        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 }; // already sorted end times

        System.out.println("Maximum Activities: " + maxActivities(start, end));
    }
}

    

