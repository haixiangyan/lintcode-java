import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC58 {
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (numbers == null || numbers.length < 4) {
            return results;
        }

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 3; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }

            threeSum(numbers, numbers[i], i + 1, target, results);
        }

        return results;
    }

    private void threeSum(int[] numbers, int firstNum, int start, int target, List<List<Integer>> results) {
        for (int i = start; i < numbers.length - 2; i++) {
            if (i > start && numbers[i] == numbers[i - 1]) {
                continue;
            }

            twoSum(numbers, firstNum, numbers[i], i + 1, numbers.length - 1, target, results);
        }
    }

    private void twoSum(int[] numbers, int firstNum, int secondNum, int left, int right, int target, List<List<Integer>> results) {
        while (left < right) {
            int sum = firstNum + secondNum + numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            }
            else if (sum > target) {
                right--;
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(firstNum);
                list.add(secondNum);
                list.add(numbers[left]);
                list.add(numbers[right]);

                results.add(list);
                left++;
                right--;

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
