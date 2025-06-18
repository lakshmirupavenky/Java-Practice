import java.util.*;
interface Master {
    int guess(String word);
}
class MasterImpl implements Master {
    private String secret;
    private int attempts = 0;
    public MasterImpl(String secret) {
        this.secret = secret;
    }
    @Override
    public int guess(String word) {
        attempts++;
        int match = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (word.charAt(i) == secret.charAt(i)) {
                match++;
            }
        }
        System.out.println("Attempt " + attempts + ": Guessed \"" + word + "\", Matches = " + match);
        return match;
    }
}
public class WordFind {
    public void findSecretWord(String[] wordlist, Master master) {
        Random random = new Random();
        for (int i = 0, matches = 0; i < 10 && matches != 6; i++) {
            String guess = wordlist[random.nextInt(wordlist.length)];
            matches = master.guess(guess);
            List<String> candidates = new ArrayList<>();
            for (String word : wordlist) {
                if (matches == getMatches(guess, word)) {
                    candidates.add(word);
                }
            }
            wordlist = candidates.toArray(new String[0]);
        }
    }
    private int getMatches(String word1, String word2) {
        int matches = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                matches++;
            }
        }
        return matches;
    }
    public static void main(String[] args) {
        String[] wordlist = {
            "acckzz", "ccbazz", "eiowzz", "abcczz", "acckzz", "abczzz"
        };
        String secret = "acckzz";
        Master master = new MasterImpl(secret);
        WordFind finder = new WordFind();
        finder.findSecretWord(wordlist, master);
    }
}
