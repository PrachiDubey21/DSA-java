public class TowerOfHanoi {
   

        public static void towerOfHanoi(int n, String src, String helper, String dest) {

            // Base case
            if (n == 1) {
                System.out.println("transfer disk " + n + " from " + src + " to " + dest);
                return;
            }

            // Step 1: Transfer top n-1 disks from src → helper using dest
            towerOfHanoi(n - 1, src, dest, helper);

            // Step 2: Transfer nth disk from src → dest
            System.out.println("transfer disk " + n + " from " + src + " to " + dest);

            // Step 3: Transfer n-1 disks from helper → dest using src
            towerOfHanoi(n - 1, helper, src, dest);
        }

        public static void main(String args[]) {
            int n = 4;
            towerOfHanoi(n, "source", "helper", "destination");
        }
    }


