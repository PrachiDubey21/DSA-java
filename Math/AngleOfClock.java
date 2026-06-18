import java.util.*;

public class AngleOfClock {

    public static double angleClock(int hour, int minutes) {

        double hourHand = (hour % 12) * 30 + (minutes * 0.5);
        double minuteHand = minutes * 6;

        double diff = Math.abs(hourHand - minuteHand);

        return Math.min(diff, 360 - diff);
    }

    public static void main(String[] args) {

        int hour = 3;
        int minutes = 15;

        double answer = angleClock(hour, minutes);

        System.out.println("Hour = " + hour);
        System.out.println("Minutes = " + minutes);
        System.out.println("Angle = " + answer);
    }
    
}


// 1. Minute Hand Formula
// minuteAngle = minutes × 6
// Why × 6?

// A clock is a circle of: 360°
// The minute hand completes one full circle in: 60 minutes

// So for every 1 minute, it moves: 360 / 60 = 6°

// Therefore:
// minuteAngle = minutes × 6

// Example
// If: minutes = 15
// then: minuteAngle = 15 × 6 = 90°
// So at 3:15, the minute hand is at 90°.



// 2. Hour Hand Formula
// hourAngle = hour × 30 + minutes × 0.5

// Why hour × 30?
// The hour hand completes one full circle in: 12 hours

// A circle is: 360°
// So each hour mark is: 360 / 12 = 30°
// Therefore:
// hourAngle = hour × 30

// For example:
// 3 o'clock

// Hour hand is at:
// 3 × 30 = 90°

// Why add minutes × 0.5?
// The hour hand does not stay fixed between hour marks.

// For example:
// 3:30
// The hour hand is not exactly on 3. It has moved halfway toward 4.
// In 1 hour (60 minutes), the hour hand moves: 30°

// So in 1 minute it moves:
// 30 / 60 = 0.5°

// Hence:
// additional movement = minutes × 0.5






// Example: 3:15
// Hour hand:

// hour × 30
// = 3 × 30
// = 90°

// Extra movement due to 15 minutes:

// 15 × 0.5
// = 7.5°

// Total:

// hourAngle
// = 90 + 7.5
// = 97.5°

// Minute hand:

// 15 × 6
// = 90°

// Difference:

// |97.5 - 90|
// = 7.5°