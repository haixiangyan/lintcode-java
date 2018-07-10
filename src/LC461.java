public class LC461 {
    public int kthSmallest(int k, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        int left = start;
        int right = end;
        int pivot = nums[(start + end) / 2];

        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
                right--;
            }
        }

        if (start + k - 1 <= right) {
            return quickSelect(nums, start, right, k);
        }
        if (start + k - 1 >= left) {
            return quickSelect(nums, left, end, (k - (left - start)));
        }

        return nums[right + 1];
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 1, 2, 5};
        int k = 3;

        LC461 lc461 = new LC461();

        System.out.println(lc461.kthSmallest(k, nums));
    }
}
