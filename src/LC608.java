public class LC608 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int[] pairs = new int[2];

        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                pairs[0] = Math.min(left + 1, right + 1);
                pairs[1] = Math.max(left + 1, right + 1);
                return pairs;
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        LC608 lc608 = new LC608();

        int[] pairs = lc608.twoSum(nums, target);

        for (int i : pairs) {
            System.out.println(i);
        }
    }
}
