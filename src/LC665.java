public class LC665 {
    private int[][] dp = null;
    public LC665(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        dp = new int[n + 1][m + 1];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
}
