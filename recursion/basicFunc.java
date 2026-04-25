public class basicFunc {

    public static void reversenumber(int number) {

        if (number == 0) {
            return;
        }
        System.out.println(number);
        reversenumber(number - 1);
    }

    public static void printnumber(int number) {

        if (number == 0) {
            return; // base case
        }

        printnumber(number - 1); // recursive call
        System.out.println(number); // print on return

    }

    public static int factorial(int number) {

        if (number == 1) {
            return 1;
        }

        return number * (factorial(number - 1));
    }

    public static int Sumnumbers(int number) {
        if (number == 1) {
            return 1;
        }

        return number + (Sumnumbers(number - 1));
    }

    public static int fibo(int number) {
        if (number == 0)
            return 0; // base case
        if (number == 1)
            return 1; // base case

        return fibo(number - 1) + fibo(number - 2);
    }

    public static int pow(int number, int power) {

        // O(n)
        if (power == 1) {
            return number;
        }

        return number * pow(number, power - 1);
    }

    public static int powOptimised(int number, int power) {

        // O(log n)
        if (power == 0)
            return 1;

        int half = pow(number, power / 2); // compute once

        if (power % 2 == 0) {
            return half * half;
        } else {
            return number * half * half;
        }
    }

    public static void main(String[] args) {

        // reversenumber(10);
        // printnumber(10);
        // System.out.println(factorial(5));
        // System.out.println(Sumnumbers(5));
        // System.out.println(fibo(6));
        // System.out.println(pow(2,5));
        // System.out.println(powOptimised(2,10));

    }

}
