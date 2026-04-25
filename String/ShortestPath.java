public class ShortestPath {

    public static int ShortestPath(String path) {
        int v = 0;
        int h = 0;

        for (int i = 0; i < path.length(); i++) {
            int d = path.charAt(i);

            if (d == 's' || d == 'S') {
                v--;
            }
            else if (d == 'e' || d == 'E') {
                h++;
            } 
            else if (d == 'w' || d == 'W') {
                h--;
            }
             else if (d == 'N' || d == 'n') {
                v++;
            }
            else{
                System.out.println("invalid charachter ");
                return -1;
            }
        }
        return (int)(Math.sqrt((h*h)+(v*v)));
    }

    public static void main(String[] args) {

         String str = "WneeNESEnnn";
        int ans = ShortestPath(str);
        if (ans == -1) {
            System.out.println();
        } else {
            System.out.println("Answer is : " + ans);
        }
    }

}
