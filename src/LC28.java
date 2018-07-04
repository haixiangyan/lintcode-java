public class LC28 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        int rowIndex = binaryRowSearch(matrix, target);

        System.out.println(rowIndex);

        if (rowIndex == -1) {
            return false;
        }

        int colIndex = binaryColSearch(matrix, rowIndex, target);

        return colIndex != -1;
    }

    private int binaryColSearch(int[][] matrix, int rowIndex, int target) {
        int start = 0;
        int end = matrix[rowIndex].length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (matrix[rowIndex][mid] == target) {
                return mid;
            }
            else if (matrix[rowIndex][mid] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }

        if (matrix[rowIndex][start] == target) {
            return start;
        }
        if (matrix[rowIndex][end] == target) {
            return end;
        }

        return -1;
    }

    private int binaryRowSearch(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (matrix[mid][0] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }

        if (matrix[end][0] <= target) {
            return end;
        }
        if (matrix[start][0] <= target) {
            return start;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        int target = 11;

        LC28 lc28 = new LC28();

        System.out.println(lc28.searchMatrix(matrix, target));
    }
}
