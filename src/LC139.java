import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC139 {
    public int[] subarraySumClosest(int[] nums) {
        int[] result = new int[]{0, 0};
        if (nums == null || nums.length <= 1) {
            return result;
        }

        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, 0);

        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
            if (sumToIndex.containsKey(prefixSum[i + 1])) {
                result[0] = sumToIndex.get(prefixSum[i + 1]);
                result[1] = i;
                return result;
            }
            else {
                sumToIndex.put(prefixSum[i + 1], i + 1);
            }
        }

        for (Integer i : prefixSum) {
            System.out.print(i + "\t");
        }

        Arrays.sort(prefixSum);

        int minDiff = Integer.MAX_VALUE, leftSum = -1, rightSum = -1;
        for (int i = 0; i < prefixSum.length - 1; i++) {
            if (prefixSum[i + 1] - prefixSum[i] < minDiff) {
                minDiff = prefixSum[i + 1] - prefixSum[i];
                leftSum = prefixSum[i];
                rightSum = prefixSum[i + 1];
            }
        }

        int leftIndex = sumToIndex.get(leftSum);
        int rightIndex = sumToIndex.get(rightSum);

        result[0] = Math.min(leftIndex, rightIndex);
        result[1] = Math.max(leftIndex, rightIndex) - 1;

        return result;
    }

    public static void main(String[] args) {
        LC139 lc139 = new LC139();
        int[] list = new int[]{5,10,5,3,2,1,1,-2,-4,3};
        lc139.subarraySumClosest(list);
    }
}
