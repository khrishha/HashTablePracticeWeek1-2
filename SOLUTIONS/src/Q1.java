import java.util.*;

public class Q1 {
    private static HashMap<String, String> userRegistry = new HashMap<>();
    private static HashMap<String, Integer> attemptTracker = new HashMap<>();

    public static boolean checkAvailability(String username) {
        attemptTracker.put(username, attemptTracker.getOrDefault(username, 0) + 1);
        return !userRegistry.containsKey(username);
    }

    public static List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();
        suggestions.add(username + "1");
        suggestions.add(username + "2");
        suggestions.add(username.replace("_", "."));
        return suggestions;
    }

    public static void main(String[] args) {
        userRegistry.put("john_doe", "ID123");
        System.out.println(checkAvailability("john_doe"));
        System.out.println(suggestAlternatives("john_doe"));
    }
}