public class LC617 {
    public double maxAverage(int[] nums, int k) {
        int start = 0;
        double max = Double.NEGATIVE_INFINITY;
        long sum = 0;

        while (start + k <= nums.length) {
            sum = 0;

            // Calculate the average for k elements
            for (int i = start; i < start + k; i++) {
                sum = sum + nums[i];
            }

            if (k == nums.length) {
                return (double)sum / k;
            }

            max = ((double)sum / k > max) ? ((double)sum / k) : max;

            // Calculate the average for k+i elements
            for (int i = start + k; i < nums.length; i++) {
                sum = sum + nums[i];

                max = ((double)sum / (i - start + 1) > max) ? ((double)sum / (i - start + 1)) : max;
            }

            start ++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2147483648,-2147483648,-2147483648,-2147483648};

        int k = 3;

        LC617 lc617 = new LC617();

        System.out.println(lc617.maxAverage(nums, k));
    }
}
