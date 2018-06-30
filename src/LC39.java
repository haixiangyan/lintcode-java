import java.util.ArrayList;
import java.util.List;

public class LC39 {

    public void recoverRotatedSortedArray(List<Integer> nums) {
        if (nums == null || nums.size() <= 1) {
            return;
        }

        int len = nums.size();
        int breakPoint;
        // Find the break point
        for (breakPoint = 0 ; breakPoint < len - 1 ; breakPoint++) {
            if (nums.get(breakPoint) > nums.get(breakPoint + 1)) {
                System.out.println("point " + breakPoint);
                break;
            }
        }

        // Do left reverse
        reverse(nums, 0, breakPoint);
        // Do right reverse
        reverse(nums, breakPoint + 1, len - 1);
        // Do whole reverse
        reverse(nums, 0, len - 1);
    }

    private void reverse(List<Integer> nums, int start, int end) {
        while (start <= end) {
            int left = nums.get(start);
            int right = nums.get(end);
            int temp;

            temp = left;
            nums.set(start, right);
            nums.set(end, temp);

            start ++;
            end --;
        }
    }

    private void print(List<Integer> nums) {
        for (Integer i : nums) {
            System.out.print(i + "\t");
        }
        System.out.println("----");
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(1);
        list.add(2);
        list.add(3);

        LC39 lc39 = new LC39();

        lc39.recoverRotatedSortedArray(list);
    }
}
