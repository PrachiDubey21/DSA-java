import java.util.*;

public class AsteroidDestroyer {
    
    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {

        long wt = mass;
        Arrays.sort(asteroids);

        boolean isPossible = true;

        for(int i = 0; i < asteroids.length; i++) {

            if(wt < asteroids[i]) {

                isPossible = false;
                break;
            }

            wt += asteroids[i];
        }

        return isPossible;
    }

    public static void main(String[] args) {

        int mass = 10;

        int[] asteroids = {3, 9, 19, 5, 21};

        boolean result = asteroidsDestroyed(mass, asteroids);
        System.out.println(result);
        
    }
    
}
