public class numberpyramid {
    public static void main(String[] args) {

        System.out.println("1)");

        // 0
        // 01
        // 012
        // 0123
        // 01234

        int n = 5;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("2)");

        // 0
        // 11
        // 222
        // 3333
        // 44444

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("3)");

        // 55555
        // 4444
        // 333
        // 22
        // 1

        for (int i = n; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print(i);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("4)");

        // 54321
        // 4321
        // 321
        // 21
        // 1

        for (int i = n; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print(j);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("5)");

        // 12345
        // 1234
        // 123
        // 12
        // 1

        for (int i = n; i > 0; i--) {
            int k = 1;
            for (int j = i; j > 0; j--) {
                System.out.print(k++);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("6)");

        // 11111
        // 2222
        // 333
        // 44
        // 5

        int k = 1;
        for (int i = n; i > 0; i--) {

            for (int j = i; j > 0; j--) {
                System.out.print(k);
            }
            k++;
            System.out.println();
        }

        System.out.println();
        System.out.println("7)");

        // 56789
        // 4567
        // 345
        // 23
        // 1

        for (int i = n; i > 0; i--) {
            int r = i;
            for (int j = i; j > 0; j--) {
                System.out.print(r++);
            }

            System.out.println();
        }

        System.out.println();
        System.out.println("8)");

        // 0
        // 12
        // 234
        // 3456
        // 45678

        for (int i = 0; i < n; i++) {
            int p = i;
            for (int j = 0; j <= i; j++) {
                System.out.print(p++);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("9)");

        // 12345
        // 2345
        // 345
        // 45
        // 5

        int l = 1;
        for (int i = n; i > 0; i--) {
            int r = l++;
            for (int j = i; j > 0; j--) {
                System.out.print(r++);
            }

            System.out.println();
        }

        System.out.println();
        System.out.println("10)");

        // 1
        // 2 3
        // 4 5 6
        // 7 8 9 10
        // 11 12 13 14 15

        int p = 1;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j <= i; j++) {
                System.out.print(p++ + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("11)");

        // 1
        // 0 1
        // 1 0 1
        // 0 1 0 1
        // 1 0 1 0 1

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0)
                    System.out.print("1 ");

                else
                    System.out.print("0 ");

            }
            System.out.println();
        }

        System.out.println();
        System.out.println("12)");

        //         1
        //       1 2 1
        //     1 2 3 2 1
        //   1 2 3 4 3 2 1
        // 1 2 3 4 5 4 3 2 1

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
                System.out.print(o + " ");
            }

            // repeat num
            int rem = num - 2;
            for (int r = rem; r >= 1; r--) {
                System.out.print(r + " ");
            }

            System.out.println();

        }
    }
}
