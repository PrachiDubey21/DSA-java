public class diamond {

    public static void main(String[] args){

        //solid diamond
        int lines=5;
        int stars=1;

        //upper
        for(int i =1; i<=lines;i++){

            //spaces
            int spaces=lines-i;
            for(int j=1;j<=spaces;j++){
             System.out.print("  ");
            }

            //stars
            for(int k=1;k<=stars;k++){
                System.out.print("* ");
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
             System.out.print("  ");
            }

            //stars
            for(int k=1;k<=stars;k++){
                System.out.print("* ");
            }
                  stars=stars-2;
                  System.out.println();
        }

        System.out.println();
        System.out.println();



        //hollow diamond
        lines=5;
        stars=1;

        //upper
        for(int i =1; i<=lines;i++){

            //spaces
            int spaces=lines-i;
            for(int j=1;j<=spaces;j++){
             System.out.print("  ");
            }

            //stars
            for(int k=1;k<=stars;k++){
                 if(i==1  || k==1 || k==stars ){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
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
             System.out.print("  ");
            }

            //stars
            for(int k=1;k<=stars;k++){
                 if(i==1 || k==1 || k==stars ){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
                  stars=stars-2;
                  System.out.println();
        }

        System.out.println();
        System.out.println();



        //inverted diamond
        int n = 5;

        //upper
        for(int i=n ; i>=1 ; i--){

            //spaces
            int spaces = n - i ;
            for(int k=0 ;k<spaces ;k++){
                System.out.print("  ");
            }

            //stars
            int k = 2*i -1 ;
            for(int j=0;j<k;j++){
                System.out.print("* ");
            }
            System.out.println();
        }

        //lower
            for(int i=2 ; i<=n ; i++){

            //spaces
            int spaces = n - i ;
            for(int k=0 ;k<spaces ;k++){
                System.out.print("  ");
            }

            //stars
            int k = 2*i -1 ;
            for(int j=0;j<k;j++){
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

    }
    
}
