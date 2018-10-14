public class LC38 {
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int count = 0;
        int row = matrix.length, col = matrix[0].length;
        int rowIndex = matrix.length - 1, colIndex = 0;

        while (rowIndex >= 0 && colIndex < col) {
            if (matrix[rowIndex][colIndex] == target) {
                count++;
                rowIndex--;
                colIndex++;
            }
            else if (matrix[rowIndex][colIndex] > target) {
                rowIndex--;
            }
            else {
                colIndex++;
            }
        }

        return count;
    }
}
