public class countSetBits {

    public static int count(int number){
        
        int count=0;
        for(int i=0;number!=0;i++){

           // gives LSB
             if((number&1)==1){
                count++;
            }
            number=number>>1;
            
        }
        return count;
    }

       public static int count2(int number){
        
        int count=0;
       
        while(number !=0){
            number = number & (number-1);
            count++;
        }

        return count;
    }
    public static void main(String[] args){

        System.out.println(count2(10));

    }
    
}
