public class LC41 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0, minSum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            maxSum = Math.max(maxSum, sum - minSum);
            minSum = Math.min(sum, minSum);
        }

        return maxSum;
    }
}
