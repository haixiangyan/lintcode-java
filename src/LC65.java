public class LC65 {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int n = A.length + B.length;

        if (n % 2 == 0) {
            return (findKth(A, 0, B, 0, n / 2) + findKth(A, 0, B, 0, n / 2 + 1)) / 2.0;
        }

        return findKth(A, 0, B, 0, n / 2 + 1);
    }

    private int findKth(int[] A, int startOfA,
                        int[] B, int startOfB,
                        int k) {
        if (startOfA >= A.length) {
            return B[startOfB + k - 1];
        }
        if (startOfB >= B.length) {
            return A[startOfA + k - 1];
        }

        if (k == 1) {
            return Math.min(A[startOfA], B[startOfB]);
        }

        int halfKthOfA = (startOfA + k / 2 - 1 < A.length) ? A[startOfA + k / 2 - 1] : Integer.MAX_VALUE;
        int halfKthOfB = (startOfB + k / 2 - 1 < B.length) ? B[startOfB + k / 2 - 1] : Integer.MAX_VALUE;

        if (halfKthOfA < halfKthOfB) {
            return findKth(A, startOfA + k / 2, B, startOfB, k - k / 2);
        }
        else {
            return findKth(A, startOfA, B, startOfB + k / 2, k - k / 2);
        }
    }
}
