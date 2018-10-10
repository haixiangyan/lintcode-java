import java.util.Arrays;

public class LC587 {
    public int twoSum6(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int count = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int v = nums[left] + nums[right];
            if (v == target) {
                count++;
                left++;
                right--;

                // Skip duplicate
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            }
            else if (v > target) {
                right--;
            }
            else {
                left++;
            }
        }
        return count;
    }
}
