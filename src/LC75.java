public class LC75 {
    public int findPeak(int[] A) {
        int start = 0;
        int end = A.length - 1;

        while(start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (A[mid] > A[mid + 1]) {
                end = mid;
            } else if (A[mid - 1] < A[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return A[start] > A[end] ? start : end;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 1, 3, 4, 5, 7, 6};

        LC75 lc75 = new LC75();

        System.out.println(lc75.findPeak(A));
    }
}
