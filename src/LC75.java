public class LC75 {
    public int findPeak(int[] A) {
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (A[mid - 1] < A[mid]) {
                start = mid;
            }
            else if (A[mid] > A[mid + 1]) {
                end = mid;
            }
            else {
                end = mid;
            }
        }

        if (A[start] > A[end]) {
            return start;
        }
        else {
            return end;
        }
    }
}
