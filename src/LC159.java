public class LC159 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;
        int target = nums[end];

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] >= target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }

        return nums[start] >= nums[end] ? nums[end] : nums[start];
    }

    public static void main(String[] args) {
        LC159 lc159 = new LC159();

        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        System.out.println(lc159.findMin(nums));
    }
}
