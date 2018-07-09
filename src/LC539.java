public class LC539 {
    public void moveZeroes(int[] nums) {
        int pos = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos] = nums[i];
                pos++;
            }
        }

        // Set to zero
        for (int i = pos; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0};

        LC539 lc539 = new LC539();

        lc539.moveZeroes(nums);

        for (int i : nums) {
            System.out.println(i);
        }
    }
}
