public class LexicographicallySmallestString {

    public static String smallestString(int N, int K) {

        char[] result = new char[N];

        for (int i = 0; i < N; i++) {
            result[i] = 'a';
        }

        int remaining = K - N;

        int index = N - 1;
        while (remaining > 0 && index >= 0) {

            int add;
            if (remaining >= 25) {
                add = 25;
            } else {
                add = remaining;
            }

            result[index] = (char) (result[index] + add);
            remaining = remaining - add;
            index--;
        }

        return new String(result);
    }

    public static void main(String[] args) {

        System.out.println(smallestString(5, 42)); 
        System.out.println(smallestString(3, 25)); 
    }
}
