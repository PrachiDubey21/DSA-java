public class HollowBasic {

    public static void main(String[] args){
       
        //for boundary condition
        //one of the row and columns must be either 1st and last

        //hollow rectangle
        int row=5;
        int col=7;

        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                if(i==1 || i==row || j==1 || j==col ){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
            
        }
        System.out.println();
        System.out.println();



         //hollow right angle

         int n = 5;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if(i==1 || i==n || j==1 || j==i ){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
            
        }
        System.out.println();
        System.out.println();

        



    }

    
}
