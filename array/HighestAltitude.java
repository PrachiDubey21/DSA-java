public class HighestAltitude {

    public static void main(String[] args) {

        // Input gain array
        int[] gain = {-5, 1, 5, 0, -7};

        // Starting altitude
        int currentAltitude = 0;

        // Highest altitude
        int maxAltitude = 0;

        // Traverse gain array
        for(int i = 0; i < gain.length; i++) {

            // Update current altitude
            currentAltitude += gain[i];

            // Update maximum altitude
            if(currentAltitude > maxAltitude) {

                maxAltitude = currentAltitude;
            }
        }

        // Print answer
        System.out.println("Highest Altitude = " + maxAltitude);
    }
    
}
