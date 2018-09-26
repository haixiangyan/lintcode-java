public class LC817 {
    private int[][] arr, bit;
    private int n, m;

    public LC817(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;

        arr = new int[n][m];
        bit = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        int delta = val - arr[row][col];
        arr[row][col] = val;

        for (int i = row + 1; i <= n; i = i + lowbit(i)) {
            for (int j = col + 1; j <= m; j = j + lowbit(j)) {
                bit[i][j] += delta;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return (
                prefixSum(row2, col2) -
                        prefixSum(row2, col1 - 1) -
                        prefixSum(row1 - 1, col2) +
                        prefixSum(row1 - 1, col1 - 1)
        );
    }

    private int prefixSum(int row, int col) {
        int sum = 0;
        for (int i = row + 1; i > 0; i = i - lowbit(i)) {
            for (int j = col + 1; j > 0; j = j - lowbit(j)) {
                sum += bit[i][j];
            }
        }
        return sum;
    }

    private int lowbit(int x) {
        return x & (-x);
    }
}
