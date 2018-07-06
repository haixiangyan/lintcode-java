public class LC63 {
    public boolean search(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 0, 1, 1, 1};

        int target = 0;

        LC63 lc63 = new LC63();

        System.out.println(lc63.search(A, target));
    }
}
