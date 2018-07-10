import java.util.Arrays;

public class LC609 {
    public int twoSum5(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        int count = 0;

        Arrays.sort(nums);

        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                count = count + (right - left);
                left++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        LC609 lc609 = new LC609();

        int[] nums = {2, 7, 11, 15};
        int target = 24;

        System.out.println(lc609.twoSum5(nums, target));
    }
}
