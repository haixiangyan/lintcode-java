import java.util.Arrays;
import java.util.Comparator;

public class LC56 {
    class Pair {
        int value;
        int index;
        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair p1, Pair p2) {
            return p1.value - p2.value;
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        Pair[] pairs = new Pair[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            pairs[i] = new Pair(numbers[i], i);
        }

        Arrays.sort(pairs, new PairComparator());

        int[] results = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (pairs[left].value + pairs[right].value == target) {
                results[0] = Math.min(pairs[left].index, pairs[right].index);
                results[1] = Math.max(pairs[right].index, pairs[left].index);
                return results;
            }
            if (pairs[left].value + pairs[right].value < target) {
                left++;
            }
            else {
                right--;
            }
        }

        return results;
    }
}
