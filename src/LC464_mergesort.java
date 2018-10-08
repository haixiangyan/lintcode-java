public class LC464_mergesort {
    public void sortIntegers2(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }

        int[] temp = new int[A.length];
        mergesort(A, 0, A.length - 1, temp);
    }

    private void mergesort(int[] A, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }

        mergesort(A, start, (start + end) / 2, temp);
        mergesort(A, (start + end) / 2 + 1, end, temp);
        merge(A, start, end, temp);
    }

    private void merge(int[] A, int start, int end, int[] temp) {
        int leftStart = start;
        int middle = (start + end) / 2;
        int rightStart = middle + 1;
        int index = leftStart;
        while (leftStart <= middle && rightStart <= end) {
            if (A[leftStart] < A[rightStart]) {
                temp[index++] = A[leftStart++];
            }
            else {
                temp[index++] = A[rightStart++];
            }
        }

        while (leftStart <= middle) {
            temp[index++] = A[leftStart++];
        }
        while (rightStart <= end) {
            temp[index++] = A[rightStart++];
        }

        for (int i = start; i <= end; i++) {
            A[i] = temp[i];
        }
    }
}
