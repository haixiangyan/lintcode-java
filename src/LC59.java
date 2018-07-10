import java.util.Arrays;

public class LC59 {
    public int threeSumClosest(int[] numbers, int target) {
        if (numbers == null || numbers.length <= 2) {
            return 0;
        }

        Arrays.sort(numbers);

        int min = Integer.MAX_VALUE;
        int minSum = 0;

        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1;
            int right = numbers.length - 1;
            int newTarget = target - numbers[i];

            while (left < right) {
                if (Math.abs(target - (numbers[left] + numbers[right] + numbers[i])) < min) {
                    min = Math.abs(target - (numbers[left] + numbers[right] + numbers[i]));
                    minSum = numbers[left] + numbers[right] + numbers[i];
                }

                if (numbers[left] + numbers[right] > newTarget) {
                    right--;
                } else if (numbers[left] + numbers[right] < newTarget) {
                    left++;
                } else {
                    return numbers[left] + numbers[right] + numbers[i];
                }
            }
        }

        return minSum;
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,0,0,-2,2,-5,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99};
        int target = 25;

        LC59 lc59 = new LC59();

        System.out.println(lc59.threeSumClosest(numbers, target));
    }
}
