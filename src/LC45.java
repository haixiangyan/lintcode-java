public class LC45 {
    public int maxDiffSubArrays(int[] nums) {
        int size = nums.length;
        int[] rightMax = new int[size];
        int[] rightMin = new int[size];
        int[] leftMax = new int[size];
        int[] leftMin = new int[size];
        int[] copy = new int[size];

        for (int i = 0; i < size; i++) {
            copy[i] = -nums[i];
        }

        int max = Integer.MIN_VALUE;
        int minSum = 0;
        int sum = 0;

        for (int i = 0; i < size; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            leftMax[i] = max;
        }

        max = Integer.MIN_VALUE;
        minSum = 0;
        sum = 0;
        for (int i = size - 1; i >= 0; i--) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            rightMax[i] = max;
        }

        max = Integer.MIN_VALUE;
        minSum = 0;
        sum = 0;
        for (int i = 0; i < size; i++) {
            sum += copy[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            leftMin[i] = -max;
        }

        max = Integer.MIN_VALUE;
        minSum = 0;
        sum = 0;
        for (int i = size - 1; i >= 0; i--) {
            sum += copy[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            rightMin[i] = -max;
        }

        int diff = 0;
        for (int i = 0; i < size - 1; i++) {
            diff = Math.max(diff, Math.abs(leftMin[i] - rightMax[i + 1]));
            diff = Math.max(diff, Math.abs(leftMax[i] - rightMin[i + 1]));
        }

        return diff;
    }
}
