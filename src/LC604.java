public class LC604 {
    public int[] winSum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] sums = new int[nums.length - k + 1];
        // Init sums[0]
        for (int i = 0; i < k; i++) {
            sums[0] += nums[i];
        }
        // Get all sums
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] - nums[i - 1] + nums[i + k - 1];
        }

        return sums;
    }
}
