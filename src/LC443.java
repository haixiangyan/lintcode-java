import java.util.Arrays;

public class LC443 {
    public int twoSum2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int count = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] <= target) {
                left++;
            }
            else {
                count = count + (right - left);
                right--;
            }
        }

        return count;
    }
}
