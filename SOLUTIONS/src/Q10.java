import java.util.*;

public class Q10 {
    private static Map<String, String> L1 = new LinkedHashMap<>(10, 0.75f, true);
    private static Map<String, String> L2 = new HashMap<>();
    private static Map<String, Integer> counts = new HashMap<>();

    public static String getVideo(String id) {
        if (L1.containsKey(id)) return "L1: " + L1.get(id);
        if (L2.containsKey(id)) {
            String data = L2.get(id);
            counts.put(id, counts.getOrDefault(id, 0) + 1);
            if (counts.get(id) > 2) {
                L1.put(id, data);
                L2.remove(id);
            }
            return "L2: " + data;
        }
        return "L3 MISS";
    }

    public static void main(String[] args) {
        L2.put("v1", "Data");
        System.out.println(getVideo("v1"));
        System.out.println(getVideo("v1"));
        System.out.println(getVideo("v1"));
    }
}