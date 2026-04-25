import java.util.Stack;

public class duplicateparenthesis {

    public static boolean find(String str){
       
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length();i++){

            char curr = str.charAt(i);

            if(curr != ')'){
                s.push(curr);
            }
            else{
                int count = 0;

                 // pop until '(' is found
                while(!s.isEmpty() && s.peek() != '(') {
                    s.pop();
                    count++;
                }

                //given that it is already a valid string
                // now top must be '(' → pop it also
                if(!s.isEmpty()) {
                    s.pop();
                }

                if(count==0){
                    return true;
                }
                
            }

        }
        return false;
        
    }

    public static void main(String[] args) {

        String str = "((a+b)*(c+(d)))";

        boolean ans = find(str);

        if (ans) {
            System.out.println("your string has duplicate parenthesis " + str);
        } else {
            System.out.println("your string has no duplicate parenthesis " + str);
        }

    }

}
