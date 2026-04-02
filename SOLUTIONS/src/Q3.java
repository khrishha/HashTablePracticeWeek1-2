import java.util.*;

public class Q3 {
    static class DNSEntry {
        String ip;
        long expiryTime;

        DNSEntry(String ip, int ttlSeconds) {
            this.ip = ip;
            this.expiryTime = System.currentTimeMillis() + (ttlSeconds * 1000L);
        }
    }

    private static Map<String, DNSEntry> cache = new HashMap<>();

    public static String resolve(String domain) {
        if (cache.containsKey(domain)) {
            DNSEntry entry = cache.get(domain);
            if (System.currentTimeMillis() < entry.expiryTime) {
                return entry.ip;
            }
            cache.remove(domain);
        }
        String ip = "172.217.14.206";
        cache.put(domain, new DNSEntry(ip, 300));
        return ip;
    }

    public static void main(String[] args) {
        System.out.println(resolve("google.com"));
        System.out.println(resolve("google.com"));
    }
}