import java.util.HashMap;
import java.util.Map;

public class LC198 {
    public long permutationIndexII(int[] A) {
        if (A == null || A.length == 0) {
            return 0L;
        }

        Map<Integer, Integer> counter = new HashMap<>();
        long index = 1, fact = 1, multifact = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            if (counter.containsKey(A[i])) {
                counter.put(A[i], counter.get(A[i]) + 1);
                multifact = multifact * counter.get(A[i]);
            }
            else {
                counter.put(A[i], 1);
            }

            int rank = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[i]) {
                    rank++;
                }
            }

            index = index + (rank * fact / multifact);
            fact = fact * (A.length - 1);
        }

        return index;
    }
}
