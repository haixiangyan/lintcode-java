import java.util.Arrays;

public class LC587 {
    public int twoSum6(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        Arrays.sort(nums);

        int count = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                count++;
                right--;
                left++;

                while (left < right && nums[left - 1] == nums[left]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        LC587 lc587 = new LC587();

        int[] nums = {7, 11, 11, 1, 2, 3, 4};
        int target = 22;

        System.out.println(lc587.twoSum6(nums, target));
    }
}
