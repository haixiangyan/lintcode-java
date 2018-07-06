public class LC160 {
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        int min = nums[0];

        for (int i = 0; i < nums.length; i++) {
            min = (nums[i] < min) ? nums[i] : min;
        }

        return min;
    }

    public int findMin2(int[] nums) {
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

            if (nums[mid] == target) {
                end --;
            }
            else if (nums[mid] > target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return nums[start] >= nums[end] ? nums[end] : nums[start];
    }

    public static void main(String[] args) {
        int[] nums = {999, 999, 1000, 1000, 10000, 0, 999, 999, 999};

        LC160 lc160 = new LC160();

        System.out.println(lc160.findMin2(nums));
    }
}
