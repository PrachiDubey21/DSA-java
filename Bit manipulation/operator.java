public class operator {

    public static void main(String[] args){

        //And operator
        //5 =    0 1 0 1
        //6 =    0 1 1 0
        // ans = 0 1 0 0 ==4
    
        System.out.println(5&6);
        System.out.println();

        //0R operator
        //5 =    0 1 0 1
        //6 =    0 1 1 0
        // ans = 0 1 1 1 == 1+2+4=7
    
        System.out.println(5|6);
        System.out.println();

         //X0R operator
        //5 =    0 1 0 1
        //6 =    0 1 1 0
        // ans = 0 0 1 1 == 1+2=3
    
        System.out.println(5^6);
        System.out.println();

         //Not operator
        //5 =   0 0 0 0 0 .....1 0 1
        //not5 =1 1 1 1 1 .....0 1 0 
        //              +          1
        // ans= 0 0 0 0 0 .....1 1 0 == -6
        //     MSB                LSB

        //trick positive = +1 negative
        // 5 = -6

        System.out.println(~5);
        System.out.println();

        //Right shift >> operator
        //5 =    0 1 0 1
        //ans = 0 0 1 0 (shifted by one) = 2
    
        System.out.println(5>>1);
        System.out.println();

        //left shift << operator
        //5 =    0 1 0 1
        //ans =  1 0 1 0 (shifted by one) = 10
    
        System.out.println(5<<1);
        System.out.println();

        //if number is odd   LSB = 1
        //if number is even  LSB = 0
        // to get LSB  = number&1 
        // number&0 = 0

        //getith bit
        // left the number 1 with i
        // 1<<i
        int n=56;
        int i=2;
        if ((n & (1<<i)) == 0){
        System.out.println("0");
        }
        else{
            System.out.println("1");
        }

        //setith bit is set the ith position bit to 1
        // or the number with (1<<i)
        int m=10;
        i=2;
        m = m | (1<<i);
        System.out.println(m);

        //clearith bit is set the bit to 0
        // and the number with not(1<<i)

        // 1 left shift of 1  = 0 0 1 0 
        // not of this is 1 1 0 1 
        // now 1 0 1 0 & 1 1 0 1 = 1 0 0 0 

        int k=10;
        i=1 ;
        k = (k & (~(1<<i)));
        System.out.println(k);

        //updateith bit
        // if bit==0 then clear else set
        //approach 2 ->

        int number=10;
        int bit=1;
        i=2;
        //number=clearbit(10,i)
        int bitmask = bit<<i;
        number = number | bitmask;

        //clear the lastith bit
        // 1111 , i=2 
        // ans = 1100
        // number & 0 = 0
        // ~0 = 111111111....
        int no = 15;
        i=2;
        bitmask = (~0)<<i;
        System.out.println(no & bitmask);

        //clear range of bits
        //so we need something like 1110000111
        //to perform from i=4 to i=7
        // we'll do bitmask = a|b
        // a = 1110000000   ~0<<(j+1)
        // b = 0000000111    (jitni position tk last mein 1 chahiye
        //                     usko 2^i - 1  so (1<<i)-1 )
        no = 10;
        i = 2;
        int j = 4;
        int a = ~0<<(j+1);
        int b= (1<<i) -1;
        bitmask=a|b;
        System.out.println( no & bitmask);

    


















    }
    
}
