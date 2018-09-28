import java.util.ArrayList;
import java.util.List;

public class LC39 {
    public void recoverRotatedSortedArray(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                reverse(nums, 0, i);
                reverse(nums, i + 1, nums.size() - 1);
                reverse(nums, 0, nums.size() - 1);
            }
        }
    }

    private void reverse(List<Integer> nums, int left, int right) {
        for (int i = left, j = right; i < j; i++, j--) {
            Integer temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
    }
}
