public class func {

    public static void main(String[] args) {
        String str = "prachi";
        String str1 = "prachi";
        String str2 = new String("prachi");

        if (str == str1) {
            System.out.println("same");
        } else {
            System.out.println("Not same");
        }

        if (str == str2) {
            System.out.println("same");
        } else {
            System.out.println("Not same");
        }

        if (str.equals(str2)) {
            System.out.println("same");
        } else {
            System.out.println("Not same");
        }

        String str3 = "helloooo";
        System.out.println(str3.substring(0, 5));

        String[] strr={"apple" , "banana" , "cherry" , "mango"};
        //str1.compareTo(str2)
        //return 0 if same
        // -ve if str1<str2
        // +ve if str1>str2
        String largest=strr[0];
        for(int i=1;i<strr.length;i++){
            if(largest.compareTo(strr[i]) <0){
                largest=strr[i];
            }
        }
         System.out.println(largest);


         String ch = "hi im prachi" ;
         System.out.println(ch.toUpperCase());

    }
}
