import java.util.*;

public class AttendanceRecord {

    //there shouldnt be more than 2 absents
    //there should not be more than 2 consecutive lates

    public static boolean checkRecord(String s) {

        int absent = 0;
        int late = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'A') {

                absent++;

                if (absent >= 2) {
                    return false;
                }

                late = 0;
            }

            else if (s.charAt(i) == 'L') {

                late++;

                if (late >= 3) {
                    return false;
                }
            }

            else {

                late = 0;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String s1 = "PPALLP";
        String s2 = "PPALLL";

        System.out.println(s1 + " -> " + checkRecord(s1));
        System.out.println(s2 + " -> " + checkRecord(s2));
    }
    
}