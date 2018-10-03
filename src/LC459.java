public class LC459 {
    public int closestNumber(int[] A, int target) {
        int firstPos = findFirstPos(A, target);
        if (firstPos == 0) {
            return 0;
        }
        if (firstPos == A.length) {
            return A.length - 1;
        }
        if (A[firstPos] - target > target - A[firstPos - 1]) {
            return firstPos - 1;
        }
        return firstPos;
    }

    private int findFirstPos(int[] A, int target) {
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target <= A[mid]) {
                end = mid;
            }
            else {
                start = mid;
            }
        }

        if (target <= A[start]) {
            return start;
        }
        if (target <= A[end]) {
            return end;
        }
        return A.length;
    }
}
