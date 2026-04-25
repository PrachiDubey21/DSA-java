public class compression {
    
    public static StringBuilder compress(String str){
        StringBuilder s = new StringBuilder();

        int n=str.length();

        for(int i=0;i<n;i++){
            Integer count=1;

            while(i<n-1 && str.charAt(i) == str.charAt(i+1)){
                 count++;
                 i++;
            }

            s.append(str.charAt(i));
            if(count>1){
                 s.append(count.toString());
            }
        }
        return s;
    }
    public static void main(String[] args){
        String str="aaabbccdd";
        System.out.println("new string is : " + compress(str));

    }
    
}
