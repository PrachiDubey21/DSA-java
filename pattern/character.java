public class character {

    public static void main(String[] args) {

        // A
        // BC
        // DEF
        // GHIJ
        // KLMNO

        char a = 'A';
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(a++);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        // P
        // QQ
        // RRR
        // SSSS
        // TTTTT

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(a);
            }
            System.out.println();
            a++;
        }

        System.out.println();
        System.out.println();

        // A
        // AB
        // ABC
        // ABCD
        // ABCDE

        for (int i = 0; i < 5; i++) {
            char b = 'A';
            for (int j = 0; j <= i; j++) {
                System.out.print(b++);
            }
            System.out.println();

        }

        System.out.println();
        System.out.println();

        //         A
        //       A B A
        //     A B C B A
        //   A B C D C B A
        // A B C D E D C B A

        int n = 5;
        for (int i = 0; i < n; i++) {
            char b = (char) ('A' + n - 1);
            for (int j = 0; j <= i; j++) {
                System.out.print(b--);
            }
            System.out.println();

        }

        System.out.println();
        System.out.println();

        int m = 5;

        for (int i = 1; i <= m; i++) {

            // spaces
            int spaces = m - i;
            for (int j = 0; j < spaces; j++) {
                System.out.print("  ");
            }

            // numbers
            int num = i + 1;
            for (int o = 1; o < num; o++) {
                System.out.print((char) ('A' + o - 1) + " ");
            }

            // repeat num
            int rem = num - 2;
            for (int r = rem; r >= 1; r--) {
                System.out.print((char) ('A' + r - 1) + " ");
            }

            System.out.println();

        }

    }

}
