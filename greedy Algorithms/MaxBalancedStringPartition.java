public class MaxBalancedStringPartition {

    public static int maxBalancedPartitions(String str) {

        int countL = 0;
        int countR = 0;
        int partitions = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == 'L') {
                countL++;
            } else if (ch == 'R') {
                countR++;
            }

            if (countL == countR) {
                partitions++;
            }
        }
        return partitions;
    }

    public static void main(String[] args) {
        String str = "LRRRRLLRLLRL";
        System.out.println(maxBalancedPartitions(str));
    }
}
