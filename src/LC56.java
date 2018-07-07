import java.util.HashMap;

public class LC56 {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.get(numbers[i]) != null) {
                int[] result = { map.get(numbers[i]), i };
                return result;
            }
            map.put(target - numbers[i], i);
        }

        int[] result = {};
        return result;
    }

    public static void main(String[] args) {
        LC56 lc56 = new LC56();

        int[] numbers = {1, 0, -1};
        int target = -1;

        int[] paris = lc56.twoSum(numbers, target);

        for (Integer i : paris) {
            System.out.println(i);
        }
    }
}
