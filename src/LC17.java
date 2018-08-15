import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC17 {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return null;
        }

        List<List<Integer>> results = new ArrayList<>();

        if (nums.length == 0) {
            results.add(new ArrayList<>());
            return results;
        }

        Arrays.sort(nums);
        helper(new ArrayList<>(), nums, 0, results);

        return results;
    }

    private void helper(List<Integer> subset, int[] nums, int startIndex, List<List<Integer>> results) {
        results.add(new ArrayList<>(subset));

        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);

            helper(subset, nums, i + 1, results);

            subset.remove(subset.size() - 1);
        }
    }

    public List<List<Integer>> subsets2(int[] nums) {
        if (nums == null) {
            return null;
        }

        List<List<Integer>> results = new ArrayList<>();

        if (nums.length == 0) {
            results.add(new ArrayList<>());
            return results;
        }

        Arrays.sort(nums);
        dfs(new ArrayList<>(), nums, 0, results);

        return results;
    }

    private void dfs(List<Integer> subset, int[] nums, int index, List<List<Integer>> results) {
        if (index == nums.length) {
            results.add(new ArrayList<>(subset));
            return;
        }

        // Choose current element
        subset.add(nums[index]);
        dfs(subset, nums, index + 1, results);

        // Not choose current element
        subset.remove(subset.size() - 1);
        dfs(subset, nums, index + 1, results);
    }
}
