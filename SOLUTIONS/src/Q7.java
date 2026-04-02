import java.util.*;

public class Q7 {
    private static Map<String, Integer> queryFreq = new HashMap<>();

    public static void search(String query) {
        queryFreq.put(query, queryFreq.getOrDefault(query, 0) + 1);
    }

    public static List<String> getSuggestions(String prefix) {
        List<String> suggestions = new ArrayList<>();
        for (String query : queryFreq.keySet()) {
            if (query.startsWith(prefix)) {
                suggestions.add(query);
            }
        }
        return suggestions;
    }

    public static void main(String[] args) {
        search("java");
        search("javascript");
        System.out.println(getSuggestions("jav"));
    }
}