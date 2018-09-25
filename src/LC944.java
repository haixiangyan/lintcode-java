public class LC944 {
    public int m, n;

    public int maxSubmatrix(int[][] matrix) {
        // Edge cases
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        n = matrix.length;
        m = matrix[0].length;
        int max = Integer.MIN_VALUE;

        // Get prefix sum
        int[][] prefixSum = getPrefiexSum(matrix);

        // Do compression for row up -> down
        for (int up = 0; up < n; up++) {
            for (int down = up; down < n; down++) {
                int[] compressedArr = compress(up, down, prefixSum);
                max = Math.max(max, maxSubArray(compressedArr));
            }
        }

        return max;
    }

    public int maxSubArray(int[] array) {
        int max = Integer.MIN_VALUE;
        int min = 0;
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
        }

        return max;
    }

    public int[] compress(int up, int down, int[][] prefixSum) {
        int[] arr = new int[m];

        for (int j = 0; j < m; j++) {
            arr[j] = prefixSum[down + 1][j] - prefixSum[up][j];
        }

        return arr;
    }

    public int[][] getPrefiexSum(int[][] matrix) {
        int[][] prefiexSum = new int[n + 1][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefiexSum[i + 1][j] = prefiexSum[i][j] + matrix[i][j];
            }
        }

        return prefiexSum;
    }
}
