import java.util.Arrays;
import java.util.Comparator;

public class LC610 {
    class Pair {
        public int index, num;

        public Pair(int index, int num) {
            this.index = index;
            this.num = num;
        }
    }

    public int[] twoSum7(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[0];
        }

        // Store info for mapping
        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = new Pair(i, nums[i]);
        }

        // Sort original array
        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.num - p2.num;
            }
        });

        int i = 0;
        int j = 0;

        while (i < pairs.length) {
            while (j < pairs.length) {
                if (pairs[j].num - pairs[i].num == target) {
                    // Skip for nums[i] - nums[i]
                    if (i == j) {
                        break;
                    }
                    // Find the result
                    return new int[]{
                            Math.min(pairs[i].index + 1, pairs[j].index + 1),
                            Math.max(pairs[i].index + 1, pairs[j].index + 1)
                    };
                } else if (pairs[j].num - pairs[i].num > target) {
                    // j is going to far and can't find the answer before head
                    break;
                }
                j++;
            }
            i++;
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1};
        int target = 0;

        LC610 lc610 = new LC610();

        int[] results = lc610.twoSum7(nums, target);
        for (int i : results) {
            System.out.println(i);
        }
    }
}
