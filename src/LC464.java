public class LC464 {
    public void sortIntegers2(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }

        quicksort(A, 0, A.length - 1);
    }

    private void quicksort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start, right = end;
        int pivot = A[(start + end) / 2];
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && pivot < A[right]) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }

        quicksort(A, start, right);
        quicksort(A, left, end);
    }
}
