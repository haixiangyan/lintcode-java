import java.util.ArrayList;
import java.util.List;

public class LC152 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();

        if (k > n) {
            return results;
        }

        helper(n, k, 1, 0, new ArrayList<>(), results);
        helper2(n, k, 1, new ArrayList<>(), results);

        return results;
    }

    private void helper(int n, int k, int curNum, int curCount, List<Integer> subset, List<List<Integer>> results) {
        if (curCount == k && curNum - 1 <= n) {
            results.add(new ArrayList<>(subset));
            return;
        }

        if (curNum <= n) {
            subset.add(curNum);
            helper(n, k, curNum + 1, curCount + 1, subset, results);

            subset.remove(subset.size() - 1);
            helper(n, k, curNum + 1, curCount, subset, results);
        }
    }

    private void helper2(int n, int k, int startIndex, List<Integer> solution, List<List<Integer>> results) {
        if (solution.size() == k) {
            results.add(new ArrayList<>(solution));
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            solution.add(i);
            helper2(n, k, startIndex + 1, solution, results);
            solution.remove(solution.size() - 1);
        }
    }
}
