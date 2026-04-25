
public class primeInRange {

    public static boolean isPrime(int n) {

        if (n == 1) {
            return false;
        }

        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void print(int range) {
        for (int i = 1; i <= range; i++) {

            if (isPrime(i)) {
                System.out.println(i);
            }

        }
    }

    public static void main(String[] args) {

        print(100);
    }

}
