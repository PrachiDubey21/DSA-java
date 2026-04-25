public class removeDuplicate {

    public static void duplicate(String str, int index , StringBuilder newstr
    , boolean[] map){

        //BASE CASE
        if(index==str.length()){
            System.out.println(newstr);
            return;
        }

        char currChar = str.charAt(index);
        if(map[currChar-'a'] == true ){
            duplicate(str, index+1, newstr, map);
        }
        else{
            map[currChar-'a'] = true ;
            duplicate(str, index+1, newstr.append(currChar), map);
        }
    }

    public static void main(String[] args){

        String str = "bbacrdcac";
        duplicate(str, 0, new StringBuilder(), new boolean[26]);

    }
    
}
