import java.util.List;

public class LC42 {
    public int maxTwoSubArrays(List<Integer> nums) {
        int size = nums.size();
        int[] left = new int[size];
        int[] right = new int[size];

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int minSum = 0;

        for (int i = 0; i < size; i++) {
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            left[i] = max;
        }

        sum = 0;
        max = Integer.MIN_VALUE;
        minSum = 0;
        for (int i = size - 1; i > 0; i--) {
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            right[i] = max;
        }

        max = Integer.MIN_VALUE;
        for (int i = 0; i < size - 1; i++) {
            max = Math.max(max, left[i] + right[i + 1]);
        }

        return max;
    }
}
