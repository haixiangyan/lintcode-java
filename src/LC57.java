import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC57 {
    public List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> results = new ArrayList<>();

        if (numbers == null || numbers.length == 0) {
            return results;
        }

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }

            int left = i + 1, right = numbers.length - 1;
            int target = -numbers[i];
            twoSum(numbers, left, right, target, results);
        }

        return results;
    }

    private void twoSum(int[] numbers, int left, int right, int target, List<List<Integer>> results) {
        List<Integer> trible;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                trible = new ArrayList<>();
                trible.add(target);
                trible.add(numbers[left]);
                trible.add(numbers[right]);
                results.add(trible);

                left++;
                right--;

                while (left < right && numbers[left] == numbers[left - 1]) {
                    left++;
                }
                while (left < right && numbers[right] == numbers[right + 1]) {
                    right--;
                }
            }
            else if (numbers[left] + numbers[right] > target) {
                right--;
            }
            else {
                left++;
            }
        }
    }
}
