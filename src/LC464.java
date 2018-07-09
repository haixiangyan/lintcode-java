public class LC464 {
    public void sortIntegers2(int[] A) {
        if (A == null || A.length == 0) {
            return;
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
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
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

        quickSort(A, start, right);
        quickSort(A, left, end);
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 1, 4, 5};

        LC464 lc464 = new LC464();

        lc464.sortIntegers2(A);

        for (int i : A) {
            System.out.println(i);
        }
    }
}
