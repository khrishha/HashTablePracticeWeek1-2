import java.util.*;

public class Q6 {
    static class TokenBucket {
        int tokens = 1000;
        long lastReset = System.currentTimeMillis();

        boolean allow() {
            if (System.currentTimeMillis() - lastReset > 3600000) {
                tokens = 1000;
                lastReset = System.currentTimeMillis();
            }
            if (tokens > 0) {
                tokens--;
                return true;
            }
            return false;
        }
    }

    private static Map<String, TokenBucket> limiters = new HashMap<>();

    public static void checkRate(String clientId) {
        TokenBucket bucket = limiters.computeIfAbsent(clientId, k -> new TokenBucket());
        if (bucket.allow()) {
            System.out.println("Allowed. Tokens: " + bucket.tokens);
        } else {
            System.out.println("Denied");
        }
    }

    public static void main(String[] args) {
        checkRate("client123");
    }
}