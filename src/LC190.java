public class LC190 {
    private void swapItem(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void swapList(int[] nums, int i, int j) {
        while (i < j) {
            swapItem(nums, i, j);
            i++;
            j--;
        }
    }

    public void nextPermutation(int[] nums) {
        int len = nums.length;

        if (len <= 1) {
            return;
        }

        int i = len - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }

        if (i != 0) {
            int j = len - 1;
            while (nums[j] <= nums[i - 1]) {
                j--;
            }
            swapItem(nums, i - 1, j);
        }

        swapList(nums, i, len - 1);
    }
}
