public class LC191 {
    public int maxProduct(int[] nums) {
        int size = nums.length;
        int[] max = new int[size];
        int[] min = new int[size];

        max[0] = nums[0];
        min[0] = nums[0];
        int result = nums[0];

        for (int i = 1; i < size; i++) {
            min[i] = max[i] = nums[i];
            if (nums[i] > 0) {
                max[i] = Math.max(max[i], max[i - 1] * nums[i]);
                min[i] = Math.min(min[i], min[i - 1] * nums[i]);
            }
            else if (nums[i] < 0) {
                max[i] = Math.max(max[i], min[i - 1] * nums[i]);
                min[i] = Math.min(min[i], max[i - 1] * nums[i]);
            }

            result = Math.max(result, max[i]);
        }

        return result;
    }
}
