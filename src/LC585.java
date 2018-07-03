/*
Given nums = [1, 2, 4, 8, 6, 3] return 8
Given nums = [10, 9, 8, 7], return 10
 */
public class LC585 {
    public int mountainSequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] >= nums[right]) {
                right --;
            }
            else if (nums[left] < nums[right]) {
                left ++;
            }
        }

        return nums[left] > nums[right] ? nums[left] : nums[right];
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 3};

        LC585 lc585 = new LC585();

        System.out.println(lc585.mountainSequence(nums));
    }
}
