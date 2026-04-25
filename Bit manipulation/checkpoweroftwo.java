public class checkpoweroftwo {

    public static void main(String[] args){
        int number = 15;
        if(number>0 && (number & (number-1)) ==0 ){
           System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }
    
}
