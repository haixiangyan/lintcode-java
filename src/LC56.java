public class LC56 {
    public int[] twoSum(int[] numbers, int target) {
        int[] pairs = {-1, -1};

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                pairs[0] = left;
                pairs[1] = right;
                return pairs;
            }

            if (numbers[left] + numbers[right] < target) {
                left ++;
            }
            else {
                right --;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        LC56 lc56 = new LC56();

        int[] numbers = {1};
        int target = 1;

        int[] paris = lc56.twoSum(numbers, target);

        for (Integer i : paris) {
            System.out.println(i);
        }
    }
}
