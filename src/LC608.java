public class LC608 {
    public int[] twoSum(int[] nums, int target) {
        int[] results = new int[2];
        if (nums == null || nums.length == 0) {
            return results;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
            }
            else if (sum < target) {
                left++;
            }
            else {
                results[0] = left + 1;
                results[1] = right + 1;
                return results;
            }
        }

        return results;
    }
}
