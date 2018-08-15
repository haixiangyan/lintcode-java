import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        if (nums == null) {
            return results;
        }

        if (nums.length == 0) {
            results.add(new ArrayList<>());
            return results;
        }

        Arrays.sort(nums);
        subsetsHelper(nums, 0, new ArrayList<>(), results);

        return results;
    }

    private void subsetsHelper(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> results) {
        results.add(new ArrayList<>(subset));

        for (int i = startIndex; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && i > startIndex) {
                continue;
            }
            subset.add(nums[i]);
            subsetsHelper(nums, i + 1, subset, results);
            subset.remove(subset.size() - 1);
        }
    }
}
