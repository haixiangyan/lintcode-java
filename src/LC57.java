import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC57 {
    public List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> lists = new ArrayList<>();
        // Sort Array
        Arrays.sort(numbers);

        // Find a + b + c = 0 => a + b = -c
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }

            // numbers[i] = c
            int left = i + 1;
            int right = numbers.length - 1;

            while (left < right) {
                if (numbers[left] + numbers[right] > -numbers[i]) {
                    right--;
                } else if (numbers[left] + numbers[right] < -numbers[i]) {
                    left++;
                } else {
                    lists.add(combine(numbers[left], numbers[right], numbers[i]));
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
        return lists;
    }

    private ArrayList<Integer> combine(int a, int b, int c) {
        ArrayList<Integer> list = new ArrayList<>();

        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));

        list.add(min);
        list.add(a + b + c - max - min);
        list.add(max);

        return list;
    }

    public static void main(String[] args) {
        int[] numbers = {-1, 0, 1};

        LC57 lc57 = new LC57();

        List<List<Integer>> lists = lc57.threeSum(numbers);

        for (List<Integer> list : lists) {
            System.out.println("----");
            for (Integer i : list) {
                System.out.println(i);
            }
        }
    }
}
