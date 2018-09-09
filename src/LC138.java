import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC138 {
    public List<Integer> subarraySum(int[] nums) {
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;

        // Init prefiexsum
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        // Init hashmap
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < prefixSum.length; i++) {
            if (!sumToIndex.containsKey(prefixSum[i])) {
                sumToIndex.put(prefixSum[i], i);
            }
            else {
                result.add(sumToIndex.get(prefixSum[i]));
                result.add(i - 1);
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LC138 lc138 = new LC138();
        List<Integer> result = lc138.subarraySum(new int[]{-3, 1, 2, -3, 4});
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}
