public class diamond {

    public static void main(String[] args){
        int lines=5;
        int stars=1;

        //upper
        for(int i =1; i<=lines;i++){

            //spaces
            int spaces=lines-i;
            for(int j=1;j<=spaces;j++){
             System.out.print(" ");
            }

            //stars
            for(int k=1;k<=stars;k++){
                System.out.print("*");
            }
                  stars=stars+2;
                  System.out.println();
        }
        
        //lower
        stars=stars-4;
        for(int i =lines-1; i>0;i--){

            //spaces
            int spaces=lines-i;
            for(int j=1;j<=spaces;j++){
             System.out.print(" ");
            }

            //stars
            for(int k=1;k<=stars;k++){
                System.out.print("*");
            }
                  stars=stars-2;
                  System.out.println();
        }

    }
    
}
