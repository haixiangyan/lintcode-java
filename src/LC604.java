public class LC604 {
    public int[] winSum(int[] nums, int k) {
        int[] sums = new int[nums.length - k + 1];

        if (nums.length == 0 ||nums.length < k) {
            return new int[0];
        }

        int sum = 0;

        // Add up font k elements
        for (int i = 0; i < k; i++) {
            sum = sum + nums[i];
        }
        sums[0] = sum;

        // Move to next
        int left = 0;
        int right = k; // Right index
        int count = 1;

        while (right < nums.length) {
            // Sub left element and add right element
            sum = sum - nums[left] + nums[right];
            sums[count] = sum;

            left ++;
            right ++;
            count ++;
        }

        return sums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 8, 5};
        int k = 1;

        LC604 lc604 = new LC604();

        int[] results = lc604.winSum(nums, k);

        for (int i : results) {
            System.out.println(i);
        }
    }
}
