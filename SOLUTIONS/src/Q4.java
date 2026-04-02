import java.util.*;

public class Q4 {
    private static Map<String, Set<String>> ngramMap = new HashMap<>();

    public static void indexDocument(String docId, String content) {
        String[] words = content.split(" ");
        int n = 3;
        for (int i = 0; i <= words.length - n; i++) {
            String ngram = String.join(" ", Arrays.copyOfRange(words, i, i + n));
            ngramMap.computeIfAbsent(ngram, k -> new HashSet<>()).add(docId);
        }
    }

    public static void checkPlagiarism(String docId, String content) {
        String[] words = content.split(" ");
        int n = 3;
        int matches = 0;
        int totalNgrams = 0;

        for (int i = 0; i <= words.length - n; i++) {
            String ngram = String.join(" ", Arrays.copyOfRange(words, i, i + n));
            if (ngramMap.containsKey(ngram)) matches++;
            totalNgrams++;
        }
        double similarity = (double) matches / totalNgrams * 100;
        System.out.println("Similarity: " + similarity + "%");
    }

    public static void main(String[] args) {
        indexDocument("doc1", "the quick brown fox jumps");
        checkPlagiarism("doc2", "the quick brown fox leaps");
    }
}