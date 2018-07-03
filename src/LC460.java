public class LC460 {

    public int[] kClosestNumbers(int[] A, int target, int k) {
        if (k == 0) {
            return new int[0];
        }

        // Find the cloest number
        int mid = binarySearch(A, target);

        int[] pairs = new int[k];
        pairs[0] = A[mid];

        int left = mid - 1, right = mid + 1;

        for (int i = 1 ; i < k ; i++) {
            if (left < 0) {
                pairs[i] = A[right];
                right ++;
            }
            else if (right == A.length) {
                pairs[i] = A[left];
                left --;
            }
            else if (Math.abs(A[left] - target) > Math.abs(A[right] - target)) {
                pairs[i] = A[right];
                right ++;
            }
            else {
                pairs[i] = A[left];
                left --;
            }
        }

        return pairs;
    }

    private int binarySearch(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (A[mid] == target) {
                return mid;
            }
            else if (A[mid] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }

        return Math.abs(A[start] - target) > Math.abs(A[end] - target) ? end : start;
    }

    public static void main(String[] args) {
        int[] A = {1,4,6,10,20};
        int target = 21;
        int k = 4;

        LC460 lc460 = new LC460();

        int[] pairs = lc460.kClosestNumbers(A, target, k);

        for (Integer i : pairs) {
            System.out.println(i);
        }
    }
}
