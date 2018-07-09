public class LC80 {
    public int median(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        return quickSelect(nums, 0, nums.length - 1, nums.length / 2 + 1);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        int left = start;
        int right = end;
        int pivot = nums[(left + right) / 2];

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

        // Left side
        if (start + k - 1 <= right) {
            return quickSelect(nums, start, right, k);
        }
        if (start + k - 1 >= left) {
            return quickSelect(nums, left, end, k - (left - start));
        }

        return nums[right + 1];
    }

    public static void main(String[] args) {
        LC80 lc80 = new LC80();

        int[] nums = {7,9,4,5};

        System.out.println(lc80.median(nums));
    }
}
