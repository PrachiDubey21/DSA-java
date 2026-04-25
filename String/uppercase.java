public class uppercase {

    public static StringBuilder touppercase(String str) {
        StringBuilder ch = new StringBuilder();

        char ci = Character.toUpperCase(str.charAt(0));
        ch.append(ci);

        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ' && i < str.length()) {
                ch.append(' ');
                c = Character.toUpperCase(str.charAt(++i));
            }
            ch.append(c);
        }
        return ch;
    }

    public static void main(String[] args) {
        String str = "hi im prachi";
        System.out.println(touppercase(str));

    }

}
