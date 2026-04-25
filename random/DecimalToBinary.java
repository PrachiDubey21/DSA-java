public class DecimalToBinary {

    public static int decnumber(int number){
        int ans=0;
        int pow=0;

        while(number!=0){
            int rem=number%2;
            ans= ans+ rem * (int) (Math.pow(10,pow++));
            number=number/2;
        }

        return ans;
    }
    public static void main(String[] args){
        int ans=decnumber(2);
        System.out.println("your number is " + ans);


    }
    
}
