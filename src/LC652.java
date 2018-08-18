import java.util.ArrayList;
import java.util.List;

public class LC652 {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> results = new ArrayList<>();

        if (n == 1) {
            return results;
        }

        getFactorsHelper(n, 2, new ArrayList<>(), results);

        return results;
    }

    private void getFactorsHelper(int n, int index, List<Integer> solution, List<List<Integer>> results) {
        if (n <= 1) {
            if (solution.size() > 1) {
                results.add(new ArrayList<>(solution));
            }
            return;
        }

        for (int i = index; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                solution.add(i);
                getFactorsHelper(n / i, i, solution, results);
                solution.remove(solution.size() - 1);
            }
        }

        if (n >= index) {
            solution.add(n);
            getFactorsHelper(1, n, solution, results);
            solution.remove(solution.size() - 1);
        }
    }
}
