public class LC197 {
    public long permutationIndex(int[] A) {
        long permutation = 1;
        long result = 0;

        for (int i = A.length - 2; i >= 0; i--) {
            int smaller = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[i]) {
                    smaller++;
                }
            }

            result = result + (smaller * permutation);
            permutation = permutation * (A.length - i);
        }

        return result + 1;
    }
}
