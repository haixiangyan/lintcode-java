public class LC463 {
    public void sortIntegers(int[] A) {
        if (A == null || A.length == 0) {
            return ;
        }

        quickSort(A, 0, A.length - 1);
    }

    private void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return ;
        }

        int left = start;
        int right = end;
        int pivot = A[(start + end) / 2];

        while (left <= right) {
            // Find left element that is smaller than the pivot
            while (left <= right && A[left] < pivot) {
                left ++;
            }
            // Find the right element that is larger than the pivot
            while (left <= right && A[right] > pivot) {
                right --;
            }

            // Swap two element
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left ++;
                right --;
            }
        }

        quickSort(A, start, right);
        quickSort(A, left, end);
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
