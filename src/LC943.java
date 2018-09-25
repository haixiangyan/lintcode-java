public class LC943 {
    private int[] prefiexSum;

    public LC943(int[] nums) {
        this.prefiexSum = new int[nums.length + 1];
        getPrefixSum(nums);
    }

    public int sumRange(int i, int j) {
        return prefiexSum[j + 1] - prefiexSum[i];
    }

    private void getPrefixSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            prefiexSum[i + 1] = prefiexSum[i] + nums[i];
        }
    }
}
