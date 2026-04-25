public class addone {

    // Add 1 to an integer using Bit Manipulation
    public static void main(String[] args) {

        // -x = ~x + 1
        // -~x = x + 1 (by replacing x by ~x)

        int x = 6;
        System.out.println(x + " + " + 1 + " is " + -~x);
        x = -4;
        System.out.println(x + " + " + 1 + " is " + -~x);
        x = 0;
        System.out.println(x + " + " + 1 + " is " + -~x);

    }

}
