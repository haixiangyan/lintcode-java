public class LC38 {
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return 0;
        }

        int right = matrix[0].length - 1;
        int left = 0;
        int top = 0;
        int bottom = matrix.length - 1;

        int count = 0;

        while (left <= right && top <= bottom) {
            if (matrix[top][right] > target) {
                // Remove this column
                right --;
            }
            else if (matrix[top][right] == target) {
                // Remove this column and this row
                right --;
                top ++;
                // Count
                count ++;
            }
            else {
                // Remove this row
                top ++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1}
        };

        int target = 1;

        LC38 lc38 = new LC38();

        System.out.println(lc38.searchMatrix(matrix, target));
    }
}
