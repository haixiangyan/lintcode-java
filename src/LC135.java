import java.util.ArrayList;
import java.util.List;

public class LC135 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null) {
            return results;
        }
        if (candidates.length == 0) {
            results.add(new ArrayList<>());
            return results;
        }

        // Remove duplicate elements
        int[] nums = removeDuplicateElements(candidates);

        // Do dfs searching
        dfs(nums, 0, target, new ArrayList<>(), results);

        return results;
    }

    private int[] removeDuplicateElements(int[] candidates) {
        int index = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[index] != candidates[i]) {
                candidates[++index] = candidates[i];
            }
        }

        int[] nums = new int[index + 1];

        for (int i = 0; i < index + 1; i++) {
            nums[i] = candidates[i];
        }

        return nums;
    }

    private void dfs(int[] nums, int index, int remainTarget, List<Integer> solution, List<List<Integer>> results) {
        if (remainTarget == 0) {
            results.add(new ArrayList<>(solution));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (remainTarget < nums[i]) {
                break;
            }
            solution.add(nums[i]);
            dfs(nums, i, remainTarget - nums[i], solution, results);
            solution.remove(solution.size() - 1);
        }
    }
}
