import java.util.*;

public class Q9 {
    public static void findTwoSum(int[] txns, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < txns.length; i++) {
            int complement = target - txns[i];
            if (map.containsKey(complement)) {
                System.out.println("Pair: " + txns[map.get(complement)] + ", " + txns[i]);
            }
            map.put(txns[i], i);
        }
    }

    public static void main(String[] args) {
        int[] vals = {500, 300, 200, 100};
        findTwoSum(vals, 500);
    }
}