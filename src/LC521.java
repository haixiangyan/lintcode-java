import java.util.Arrays;

public class LC521 {
    public int deduplication(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int pos = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[pos]) {
                // Move pos to current duplicate element
                pos++;
                // Replace duplicate element with new element
                nums[pos] = nums[i];
            }
        }

        return pos + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 4, 4, 2};

        LC521 lc521 = new LC521();

        System.out.println(lc521.deduplication(nums));

        for (int i : nums) {
            System.out.println(i);
        }
    }
}
