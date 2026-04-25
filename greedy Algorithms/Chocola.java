import java.util.*;

public class Chocola {

    public static void main(String[] args) {

        int n = 4;
        int m = 6;

        Integer Costver[] = { 2, 1, 3, 1, 4 }; // m-1
        Integer Costhor[] = { 4, 1, 2 }; // n-1

        Arrays.sort(Costver, Collections.reverseOrder());
        Arrays.sort(Costhor, Collections.reverseOrder());

        // konsa cut lg rha h
        int h = 0;
        int v = 0;

        // pieces
        int hp = 1;
        int vp = 1;

        int cost = 0;

        while (h < Costhor.length && v < Costver.length) {

            // take higher price
            if (Costhor[h] >= Costver[v]) {

                cost = cost + (Costhor[h] * vp);
                hp++;
                h++;

            } else {

                cost = cost + (Costver[v] * hp);
                vp++;
                v++;

            }
        }

        // remaining cuts
        while (h < Costhor.length) {

            cost = cost + (Costhor[h] * vp);
            hp++;
            h++;

        }

        // remaining cuts
        while (v < Costver.length) {

            cost = cost + (Costver[v] * hp);
            vp++;
            v++;

        }

        System.out.println();
        System.out.println("The minimum cost is : " + cost);
        System.out.println();
    }

}
