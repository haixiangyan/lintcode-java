public class LC462 {
    public int totalOccurrence(int[] A, int target) {
        if (A.length == 0) {
            return 0;
        }

        int index = binaryFirstSearch(A, target);
        int total = 0;

        if (index == -1) {
            return 0;
        }

        for (int i = index ; i < A.length ; i++) {
            if (A[i] != target) {
                return total;
            }

            total ++;
        }

        return total;
    }

    private int binaryFirstSearch(int[] A, int target) {
        int start = 0;
        int end = A.length -1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (A[mid] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }

        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] A = {};

        int target = 6;

        LC462 lc462 = new LC462();

        System.out.println(lc462.totalOccurrence(A, target));
    }
}
