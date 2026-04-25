public class FastExpo {

    public static double fastPower(long base, long exponent) {
         long exp = exponent;     // Use long to avoid overflow
        if (exp < 0) {
            base = 1 / base;    // Take reciprocal if exponent is negative
            exp = -exp;   // Make exponent positive
        }

        double answer = 1;

        while (exp > 0) {
            // If current bit is 1, multiply the base
            if ((exp & 1) == 1) {
                answer *= base;
            }

            // Square the base for the next bit
            base *= base;

            // Shift exponent right (divide by 2)
            exp >>= 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        // we calculate x^n but faster
        System.out.println(fastPower(3, 5)); // 243

    }

}
