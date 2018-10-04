import java.util.Arrays;
import java.util.Comparator;

public class LC610 {
    class Pair {
        public int index;
        public int value;
        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public int[] twoSum7(int[] nums, int target) {
        int[] results = new int[2];
        if (nums == null || nums.length < 2) {
            return results;
        }

        target = Math.abs(target);

        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(i, nums[i]);
        }

        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.value - o2.value;
            }
        });

        for (int i = 0; i < pairs.length; i++) {
            int j = i + 1;
            while (j < nums.length) {
                if (pairs[j].value - pairs[i].value < target) {
                    j++;
                }
                else if (pairs[j].value - pairs[i].value > target) {
                    break;
                }
                else {
                    results[0] = Math.min(pairs[i].index + 1, pairs[j].index + 1);
                    results[1] = Math.max(pairs[i].index + 1, pairs[j].index + 1);
                    return results;
                }
            }
        }

        return results;
    }
}
