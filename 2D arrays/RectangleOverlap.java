import java.util.*;

public class RectangleOverlap {

    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        if(rec1[0] >= rec2[2] || rec1[2] <= rec2[0] 
            || rec1[1] >= rec2[3] || rec1[3] <= rec2[1]) {

            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        int[] rec1 = {0, 0, 1, 1};
        int[] rec2 = {2, 2, 3, 3};

        boolean result = isRectangleOverlap(rec1, rec2);
        System.out.println(result);

    }
    
}