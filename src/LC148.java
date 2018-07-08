public class LC148 {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int i = 0;

        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
                i++;
            }
            else if (nums[i] == 2) {
                swap(nums, right, i);
                right--;
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

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 2};

        LC148 lc148 = new LC148();

        lc148.sortColors(nums);

        for (int i : nums) {
            System.out.println(i);
        }
    }
}
