import java.util.*;

public class PascalsTriangle2 {


    public static List<Integer> getRow(int rowIndex) {

        List<Integer> row = new ArrayList<>();

        // First row
        row.add(1);

        // Generate each row
        for (int i = 1; i <= rowIndex; i++) {

            // Add a dummy 0 at the end
            row.add(0);

            // Update from right to left
            for (int j = i; j > 0; j--) {

                row.set(j, row.get(j) + row.get(j - 1));

            }
        }

        return row;
    }

    public static void main(String[] args) {


        int rowIndex = 4;  
        List<Integer> ans = getRow(rowIndex);

        System.out.println(ans);

    }
}
    