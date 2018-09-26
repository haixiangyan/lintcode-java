public class LC620 {
    public int maxSubarray4(int[] nums, int k) {
        int n = nums.length;
        if (n < k) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < k; i++) {
            result += nums[i];
        }

        int[] sum = new int[n + 1];
        sum[0] = 0;

        int minPrefix = 0;
        for (int i = 1; i <= n; i++) {
            // Update prefix sum
            sum[i] = sum[i - 1] + nums[i - 1];
            if (i >= k && sum[i] - minPrefix > result) {
                result = sum[i] - minPrefix;
            }
            if (i >= k) {
                // 前 k 个的最小 sum
                minPrefix = Math.min(minPrefix, sum[i - k + 1]);
            }
        }
        return result;
    }
}
