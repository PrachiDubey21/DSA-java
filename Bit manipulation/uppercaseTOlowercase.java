public class uppercaseTOlowercase {

    public static void main(String[] args) {

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            
            // space is 32 in decimal and 0100000 in binary
            System.out.println((char) (ch | ' '));
        }
    }

}
