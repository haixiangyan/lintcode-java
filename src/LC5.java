public class LC5 {
    public int kthLargestElement(int k, int[] nums) {
        if (k > nums.length || k == 0 || nums.length == 0) {
            return -1;
        }

        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        int left = start;
        int right = end;
        int pivot = nums[(start + end) / 2];

        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left ++;
            }
            while (left <= right && nums[right] < pivot) {
                right --;
            }

            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left ++;
                right --;
            }
        }

        if (start + k - 1 <= right) {
            return quickSelect(nums, start, right, k);
        }
        if (start + k - 1 >= left) {
            // Ignore elements on left side
            return quickSelect(nums, left, end, k - (left - start));
        }

        // Pivot index
        return nums[right + 1];
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {9, 3, 2, 4, 8};

        LC5 lc5 = new LC5();

        System.out.println(lc5.kthLargestElement(k, nums));
    }
}
