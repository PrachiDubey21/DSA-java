public class binaryToDecimal {

    public static int binnumber(int number){
        int pow=0;
        int ans=0;
        while(number!=0){
            int lastno=number%10;
            ans= ans + (lastno * (int)Math.pow(2,pow++));
            number=number/10;

        }
        return ans;
    }

    public static void main(String[] args){
         int ans=binnumber(101);
        System.out.println("your number is " + ans);

    }
    
}
