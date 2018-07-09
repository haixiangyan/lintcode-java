public class LC30 {
    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            while (left <= right && nums[left] < k) {
                left++;
            }
            while (left <= right && nums[right] >= k) {
                right--;
            }

            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        return right + 1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 1};
        int k = 2;

        LC30 lc30 = new LC30();

        System.out.println(lc30.partitionArray(nums, k));

        for (int i : nums) {
            System.out.println(i);
        }
    }
}
