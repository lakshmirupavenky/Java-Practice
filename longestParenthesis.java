import java.util.*;
public class longestParenthesis {
    public int longestValidParentheses(String s) {
        int m = s.length();
        int[] dp = new int[m];
        int maxLen = 0;
        for (int i = 1; i < m; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] - 1 >= 0 &&
                           s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 +
                            (i - dp[i - 1] - 2 >= 0 ?
                             dp[i - dp[i - 1] - 2] : 0);
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        Validparenthesis vp = new Validparenthesis();       
        String test = "(()))())(";
        int result = vp.longestParentheses(test);
        System.out.println("Longest valid parentheses length: " + result);
    }
}
