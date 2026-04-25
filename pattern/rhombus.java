public class rhombus {

    public static void main(String[] args) {
        
        int lines = 5;

        for (int i = 1; i <= lines; i++) {

            int spaces = lines - i;
            
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }

            for (int k = 1; k <= lines; k++) {
                System.out.print("*");
            }

            System.out.println();
        }

        System.out.println();
        System.out.println();

        lines = 5;
        for (int i = 1; i <= lines; i++) {

            // spaces
            int spaces = lines - i;
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }

            // printing stars with hollow inside
            for (int k = 1; k <= lines; k++) {
                if (i == 1 || i == lines || k == 1 || k == lines) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();

        }
    }

}
