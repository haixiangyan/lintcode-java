public class LC625 {
    public void partition2(int[] nums, int low, int high) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int pl = 0, pr = nums.length - 1;
        int i = 0;
        while (i <= pr) {
            if (nums[i] < low) {
                swap(nums, i, pl);
                pl++;
                i++;
            }
            else if (nums[i] > high) {
                swap(nums, i, pr);
                pr--;
            }
            else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
