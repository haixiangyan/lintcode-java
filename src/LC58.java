import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC58 {
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        if (numbers == null || numbers.length <= 3) {
            return new ArrayList<>();
        }

        Arrays.sort(numbers);

        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < numbers.length - 3; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            threeSum(numbers, target - numbers[i], i + 1, lists, numbers[i]);
        }

        return lists;
    }

    private void threeSum(int[] numbers, int target, int start, List<List<Integer>> lists, int curNum) {
        for (int i = start; i < numbers.length - 2; i++) {
            if (i > start && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = numbers.length - 1;
            int newTarget = target - numbers[i];

            while (left < right) {
                if (numbers[left] + numbers[right] < newTarget) {
                    left++;
                }
                else if (numbers[left] + numbers[right] > newTarget) {
                    right--;
                }
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(numbers[left]);
                    list.add(numbers[right]);
                    list.add(numbers[i]);
                    list.add(curNum);
                    list.sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o1 - o2;
                        }
                    });
                    lists.add(list);
                    left++;
                    right--;
                    // Remove duplicate
                    while (left < right && numbers[left] == numbers[left - 1]) {
                        left++;
                    }
                    while (left < right && numbers[right] == numbers[right + 1]) {
                        right--;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1,0,-1,-1,-1,-1,0,1,1,1,2};
        int target = 2;

        LC58 lc58 = new LC58();

        List<List<Integer>> lists = lc58.fourSum(numbers, target);

        for (List<Integer> list : lists) {
            System.out.println("\n---");
            for (Integer i : list) {
                System.out.print(i);
            }
        }
    }
}
