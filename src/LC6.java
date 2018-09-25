public class LC6 {
    public int[] mergeSortedArray(int[] A, int[] B) {
        if (A == null || B == null) {
            return null;
        }

        int[] results = new int[A.length + B.length];

        int i = 0, j = 0;
        int index = 0;
        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                results[index++] = A[i++];
            }
            else {
                results[index++] = B[j++];
            }
        }

        while (i < A.length) {
            results[index++] = A[i++];
        }
        while (j < B.length) {
            results[index++] = B[j++];
        }

        return results;
    }
}
