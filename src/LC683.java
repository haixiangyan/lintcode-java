import java.util.HashSet;
import java.util.Set;

public class LC683 {
    public int wordBreak3(String s, Set<String> dict) {
        int n = s.length();
        String lowerS = s.toLowerCase();

        Set<String> lowerDict = new HashSet<>();
        for (String str : dict) {
            lowerDict.add(str.toLowerCase());
        }

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String sub = lowerS.substring(i, j + 1);
                if (lowerDict.contains(sub)) {
                    dp[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = i; k < j; k++) {
                    dp[i][j] += (dp[i][k] * dp[k + 1][j]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
