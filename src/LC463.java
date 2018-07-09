public class LC463 {
    public void sortIntegers(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }

        int[] temp = new int[A.length];

        mergeSort(A, 0, A.length - 1, temp);
    }

    private void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start;
        int right = end;
        int pivot = A[(start + end) / 2];

        while (left <= right) {
            // Find left element that is smaller than the pivot
            while (left <= right && A[left] < pivot) {
                left++;
            }
            // Find the right element that is larger than the pivot
            while (left <= right && A[right] > pivot) {
                right--;
            }

            // Swap two element
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }

        quickSort(A, start, right);
        quickSort(A, left, end);
    }

    private void mergeSort(int[] A, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }

        mergeSort(A, start, (start + end) / 2, temp);
        mergeSort(A, (start + end) / 2 + 1, end, temp);
        merge(A, start, end, temp);
    }

    private void merge(int[] A, int start, int end, int[] temp) {
        int middle = (start + end) / 2;
        int leftIndex = start;
        int rightIndex = middle + 1;
        int index = leftIndex;

        while (leftIndex <= middle && rightIndex <= end) {
            if (A[leftIndex] < A[rightIndex]) {
                temp[index++] = A[leftIndex++];
            } else {
                temp[index++] = A[rightIndex++];
            }
        }

        while (leftIndex <= middle) {
            temp[index++] = A[leftIndex++];
        }
        while (rightIndex <= end) {
            temp[index++] = A[rightIndex++];
        }

        for (int i = start; i <= end; i++) {
            A[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 1, 4, 5};

        LC463 lc463 = new LC463();

        lc463.sortIntegers(A);

        for (int i : A) {
            System.out.println(i);
        }
    }
}
