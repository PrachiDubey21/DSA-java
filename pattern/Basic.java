public class Basic {

    public static void main(String[] args){

        System.out.println();
        System.out.println();

        //square
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();



        //rectangle
        for(int i=0;i<4;i++){
            for(int j=0;j<8;j++){
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();



        //right triangle
        for(int i=0;i<5;i++){
            for(int j=0;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();



         //inverted right triangle
        for(int i=5;i>=0;i--){
            for(int j=i;j>0;j--){
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();



        //solid pyramid pattern
        int n = 5;

        for(int i=1 ; i<=n ; i++){

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



        // inverted solid pyramid pattern
        n = 5;

        for(int i=n ; i>=0 ; i--){

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
