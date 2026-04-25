import java.util.Stack;

public class reverseString {

    public static void reverse(String str){

          Stack <Character> s = new Stack<>();
          int index = 0;

          while(index < str.length()){
            s.push(str.charAt(index));
            index++;
          }

          StringBuilder result = new StringBuilder("");
          
          while( !s.isEmpty() ){
            char curr = s.pop();
            result.append(curr);
          }

          str = result.toString();
          System.out.println(str);

    }

    public static void main(String[] args){

         reverse("abcd");

    }
    
}
