public class LC196 {
    public int findMissing(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 != nums[i]) {
                return nums[i] - 1;
            }
        }

        return -1;
    }
}
