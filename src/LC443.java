import java.util.Arrays;

public class LC443 {
    public int twoSum2(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int count = 0;

        while (left < right) {
            if (nums[left] + nums[right] > target) {
                count = count + (right - left);
                right--;
            } else {
                left++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99};
        int target = -64;

        LC443 lc443 = new LC443();

        System.out.println(lc443.twoSum2(nums, target));
    }
}
