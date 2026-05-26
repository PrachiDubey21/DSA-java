import java.util.*;

public class ReturnToOrigin {

    public static boolean judgeCircle(String moves) {

        int x = 0;
        int y = 0;

        for(int i = 0; i < moves.length(); i++) {

            char ch = moves.charAt(i);

            if(ch == 'U') {
                y++;
            }
            else if(ch == 'D') {
                y--;
            }
            else if(ch == 'L') {
                x--;
            }
            else if(ch == 'R') {
                x++;
            }
        }

        return x == 0 && y == 0;
    }

    public static void main(String[] args) {

        String moves = "UDLR";

        boolean result = judgeCircle(moves);
        System.out.println(result);

    }
    
}
