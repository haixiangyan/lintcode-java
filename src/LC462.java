public class LC462 {
    public int totalOccurrence(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int first = findFirstPos(A, target);
        int end = findLastPos(A, target);
        if (first == -1 || end == -1) {
            return 0;
        }
        return end - first + 1;
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

        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }
        return -1;
    }

    private int findLastPos(int[] A, int target) {
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }

        if (A[end] == target) {
            return end;
        }
        if (A[start] == target) {
            return start;
        }
        return -1;
    }
}
