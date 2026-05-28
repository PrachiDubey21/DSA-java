import java.util.*;

public class ToLowerCase {

    public static void main(String[] args){

        String s = "HELLO";

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if(ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32);
            }

            sb.append(ch);
        }

      //  return sb.toString();
      System.out.println(sb);
    }
    
}
