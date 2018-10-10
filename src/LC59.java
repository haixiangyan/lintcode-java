import java.util.Arrays;

public class LC59 {
    public int threeSumClosest(int[] numbers, int target) {
        if (numbers == null || numbers.length < 3) {
            return 0;
        }

        Arrays.sort(numbers);

        int bestSum = numbers[0] + numbers[1] + numbers[2];
        for (int i = 0; i < numbers.length - 2; i++) {
            bestSum = twoSumClosest(numbers, i + 1, numbers.length - 1, numbers[i], target, bestSum);
        }

        return bestSum;
    }

    private int twoSumClosest(int[] numbers, int start, int end, int curNum, int target, int bestSum) {
        while (start < end) {
            int sum = curNum + numbers[start] + numbers[end];
            if (Math.abs(target - sum) < Math.abs(target - bestSum)) {
                bestSum = sum;
            }
            if (sum < target) {
                start++;
            }
            else {
                end--;
            }
        }

        return bestSum;
    }
}
