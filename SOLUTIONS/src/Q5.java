import java.util.*;

public class Q5 {
    private static Map<String, Integer> pageViews = new HashMap<>();
    private static Map<String, Set<String>> uniqueVisitors = new HashMap<>();

    public static void processEvent(String url, String userId) {
        pageViews.put(url, pageViews.getOrDefault(url, 0) + 1);
        uniqueVisitors.computeIfAbsent(url, k -> new HashSet<>()).add(userId);
    }

    public static void getDashboard() {
        pageViews.forEach((url, count) -> {
            int unique = uniqueVisitors.get(url).size();
            System.out.println(url + " - Views: " + count + " Unique: " + unique);
        });
    }

    public static void main(String[] args) {
        processEvent("/news", "u1");
        processEvent("/news", "u2");
        getDashboard();
    }
}