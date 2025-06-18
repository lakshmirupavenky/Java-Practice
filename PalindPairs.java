import java.util.*;
public class PalindPairs {
    private static class TrieNode {
        TrieNode[] next;
        int ind;
        List<Integer> list;
        TrieNode() {
            next = new TrieNode[26];
            ind = -1;
            list = new ArrayList<>();
        }
    }
    public List<List<Integer>> palindPairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            search(words, i, root, res);
        }
        return res;
    }
    private void addWord(TrieNode root, String word, int ind) {
        for (int i = word.length() - 1; i >= 0; i--) {
            int j = word.charAt(i) - 'a';
            if (root.next[j] == null) {
                root.next[j] = new TrieNode();
            }
            if (isPalindrome(word, 0, i)) {
                root.list.add(ind);
            }
            root = root.next[j];
        }
        root.list.add(ind);
        root.ind = ind;
    }
    private void search(String[] words, int i, TrieNode root, List<List<Integer>> res) {
        for (int j = 0; j < words[i].length(); j++) {
            if (root.ind >= 0 && root.ind != i && isPalindrome(words[i], j, words[i].length() - 1)) {
                res.add(Arrays.asList(i, root.ind));
            }
            root = root.next[words[i].charAt(j) - 'a'];
            if (root == null) return;
        }
        for (int j : root.list) {
            if (i == j) continue;
            res.add(Arrays.asList(i, j));
        }
    }
    private boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        PalindPairs pp = new PalindPairs();
        String[] words = {"bat", "tab", "cat", "tac", "at"};
        List<List<Integer>> pairs = pp.palindPairs(words);
        System.out.println("Palindrome Pairs (ind-based):");
        for (List<Integer> pair : pairs) {
            System.out.println(pair);
        }
        System.out.println("\nPalindrome Pairs (words):");
        for (List<Integer> pair : pairs) {
            System.out.println("[" + words[pair.get(0)] + ", " + words[pair.get(1)] + "]");
        }
    }
}
