import java.util.HashMap;
import java.util.Map;

public class LC405 {
    public int[][] submatrixSum(int[][] matrix) {
        int[][] results = new int[2][2];

        int n = matrix.length;
        if (n == 0) {
            return results;
        }
        int m = matrix[0].length;
        if (m == 0) {
            return results;
        }
        int[][] prefixSum = new int[n + 1][m + 1];

        // Init prefix sum
        for (int i = 0; i < n + 1; i++) {
            prefixSum[i][0] = 0;
        }
        for (int j = 0; j < m + 1; j++) {
            prefixSum[0][j] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefixSum[i + 1][j + 1] = prefixSum[i][j + 1] + prefixSum[i + 1][j] + matrix[i][j] - prefixSum[i][j];
            }
        }

        for (int up = 0; up < n; up++) {
            for (int down = up + 1; down < n + 1; down++) {
                Map<Integer, Integer> map = new HashMap<>();
                for (int curtRowCol = 0; curtRowCol < m + 1; curtRowCol++) {
                    int diff = prefixSum[down][curtRowCol] - prefixSum[up][curtRowCol];
                    if (map.containsKey(diff)) {
                        results[0][0] = up;
                        results[0][1] = map.get(diff);
                        results[1][0] = down - 1;
                        results[1][1] = curtRowCol - 1;
                        return results;
                    }
                    else {
                        map.put(diff, curtRowCol);
                    }
                }
            }
        }

        return results;
    }
}
