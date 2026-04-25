public class character{

    public static void main(String[] args){
        char a = 'A';
         for(int i=0;i<5;i++){
            for(int j=0;j<=i;j++){
                System.out.print(a++);
            }
            System.out.println();
        }

        System.out.println();

         for(int i=0;i<5;i++){
            for(int j=0;j<=i;j++){
                System.out.print(a);
            }
            System.out.println();
            a++;
        }
    }
    
}
