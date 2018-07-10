import java.util.Arrays;

public class LC533 {
    public int twoSumClosest(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while (left < right) {
            if (Math.abs(target - (nums[left] + nums[right])) < min) {
                min = Math.abs(target - (nums[left] + nums[right]));
            }

            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                return 0;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        LC533 lc533 = new LC533();

        int[] nums = {-1, 2, 1, -4};
        int target = 4;

        System.out.println(lc533.twoSumClosest(nums, target));
    }
}
