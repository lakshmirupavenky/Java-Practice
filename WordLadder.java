import java.util.*;
class Word {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int changes = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) return changes;
                for (int j = 0; j < word.length(); j++) {
                    char[] arr = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (arr[j] == c) continue;
                        arr[j] = c;
                        String nextWord = new String(arr);
                        if (set.contains(nextWord) && !visited.contains(nextWord)) {
                            queue.add(nextWord);
                            visited.add(nextWord);
                        }
                    }
                }
            }
            changes++;
        }
        return 0;
    }
}
public class WordLadder {
    public static void main(String[] args) {
        Word sol = new Word(); // FIXED: use the correct class name
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        int result = solution.ladderLength(beginWord, endWord, wordList);
        System.out.println("Shortest transformation sequence length: " + result);
    }
}
