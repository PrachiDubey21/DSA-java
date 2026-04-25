public class trianglehalfPyramid {

    public static void main(String[] args) {
        int lines = 7;

        for (int i = 1; i <= lines; i++) {

            int spaces = lines - i;
            

            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }

            int stars = i;
            for (int k = 1; k <= stars; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
