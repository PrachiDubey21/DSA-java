import java.util.HashMap;
import java.util.HashSet;

public class ItineraryFromTickets {

    
    public static void findItinerary(HashMap<String, String> tickets) {

        HashSet<String> destinations = new HashSet<>();

        // Store all destination cities
        for (String dest : tickets.values()) {
            destinations.add(dest);
        }

        // Find starting city
        String start = null;
        for (String src : tickets.keySet()) {
            if (!destinations.contains(src)) {
                start = src;
                break;
            }
        }

        // Print the itinerary
        while (tickets.containsKey(start)) {
            System.out.print(start + " -> ");
            start = tickets.get(start);
        }

        System.out.println(start);
    }

    // Main method
    public static void main(String[] args) {

        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bangalore");
        tickets.put("Bombay", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        findItinerary(tickets);
    }
}
