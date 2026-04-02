import java.util.*;

public class Q2 {
    private static Map<String, Integer> inventory = new HashMap<>();
    private static LinkedHashMap<Integer, String> waitingList = new LinkedHashMap<>();

    public static void purchaseItem(String productId, int userId) {
        synchronized(inventory) {
            int stock = inventory.getOrDefault(productId, 0);
            if (stock > 0) {
                inventory.put(productId, stock - 1);
                System.out.println("Success. Remaining: " + (stock - 1));
            } else {
                waitingList.put(userId, productId);
                System.out.println("Added to waiting list.");
            }
        }
    }

    public static void main(String[] args) {
        inventory.put("ITEM01", 1);
        purchaseItem("ITEM01", 101);
        purchaseItem("ITEM01", 102);
    }
}