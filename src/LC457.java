public class LC457 {

    public int findPosition(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        System.out.println("start: " + start + "; end: " + end);
        if (start > end) {
            return -1;
        }
        if (start == end) {
            if (nums[start] == target) {
                return start;
            }

            return -1;
        }

        int mid = (start + end) / 2;

        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, end, target);
        }

        return binarySearch(nums, start, mid - 1, target);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,5,5,6,6,6};
        int target = 5;

        LC457 lc457 = new LC457();

        System.out.println(lc457.findPosition(nums, target));
    }
}
