public class LC461 {
    public int kthSmallest(int k, int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        return quickselect(nums, 0, nums.length - 1, k);
    }

    private int quickselect(int[] nums, int start, int end, int k) {
        // Check validation
        if (start >= end) {
            return nums[start];
        }

        // Get pivot
        int pivot = nums[(start + end) / 2];
        int left = start, right = end;
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
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

        if (start + k - 1 <= right) {
            return quickselect(nums, start, right, k);
        }
        if (start + k - 1 >= left) {
            return quickselect(nums, left, end, k - (left - start));
        }
        return nums[right + 1];
    }
}
