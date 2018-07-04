public class LC459 {
    public int closestNumber(int[] A, int target) {
        if (A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (A[mid] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }

        return Math.abs(A[start] - target) > Math.abs(A[end] - target) ? end : start;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 3, 4};

        int target = 3;

        LC459 lc459 = new LC459();

        System.out.println(lc459.closestNumber(A, target));
    }
}
