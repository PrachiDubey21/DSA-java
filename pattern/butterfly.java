public class butterfly {

    public static void main(String[] args){
        int lines=4;

        //upper 
        for(int i=1;i<=lines;i++){

            //left triangle
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }

            //middle spaces
            int spaces = lines-i;
            spaces=spaces*2;
            for(int j=1;j<=spaces;j++){
                System.out.print("  ");
            }

            //right triangle
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }


             System.out.println();
        }

        //lower
        for(int i=lines;i>=1;i--){

            //left triangle
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }

            //middle spaces
            int spaces = lines-i;
            spaces=spaces*2;
            for(int j=1;j<=spaces;j++){
                System.out.print("  ");
            }

            //right triangle
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }


             System.out.println();

        }
    }
    
}
