import java.util.Arrays;

public class LC533 {
    public int twoSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return Integer.MAX_VALUE;
        }

        Arrays.sort(nums);

        int diff = Integer.MAX_VALUE;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                diff = Math.min(diff, target - (nums[left] + nums[right]));
                left++;
            }
            else {
                diff = Math.min(diff, (nums[left] + nums[right]) - target);
                right--;
            }
        }

        return diff;
    }
}
