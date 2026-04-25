public class Friendspairing {

    public static int friendsPairing(int n) {

        if (n == 1 || n == 2) {
            return n;
        }

        int single = friendsPairing(n - 1);

        int pairing = friendsPairing(n - 2);
        int waysOfPairing = (n - 1) * pairing;

        return single + waysOfPairing;
    }

    public static void main(String[] args) {

        int n = 3;
        int result = friendsPairing(n);

        System.out.println("Number of ways = " + result);
    }
}
