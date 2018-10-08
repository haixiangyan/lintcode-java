public class LC5 {
    public int kthLargestElement(int k, int[] nums) {
        if (nums == null) {
            return -1;
        }

        return quickselect(nums, 0, nums.length - 1, k);
    }

    private int quickselect(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return nums[start];
        }

        int left = start, right = end;
        int pivot = nums[(start + end) / 2];
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && pivot > nums[right]) {
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
