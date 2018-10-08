public class LC148 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int pl = 0, pr = nums.length - 1;
        int i = 0;
        while (i <= pr) {
            if (nums[i] == 0) {
                swap(nums, pl, i);
                pl++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, pr);
                pr--;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
