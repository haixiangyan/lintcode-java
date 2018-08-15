import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC153 {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> results = new ArrayList<>();

        if (num == null) {
            return results;
        }
        if (num.length == 0) {
            return results;
        }

        Arrays.sort(num);
        helper(num, target, 0, 0, new ArrayList<>(), results);

        return results;
    }

    private void helper(int[] nums, int target, int startIndex, int curSum, List<Integer> solution, List<List<Integer>> results) {
        if (curSum == target) {
            results.add(new ArrayList<>(solution));
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (i != startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            if (target - curSum < nums[i]) {
                break;
            }

            solution.add(nums[i]);
            helper(nums, target, i + 1, curSum + nums[i], solution, results);
            solution.remove(solution.size() - 1);
        }
    }
}
