public class LC625 {
    public void partition2(int[] nums, int low, int high) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int lowPos = 0;
        int highPos = nums.length - 1;
        int i = 0;

        while (i < highPos) {
            if (nums[i] < low) {
                swap(nums, i, lowPos);
                lowPos++;
                i++;
            } else if (nums[i] > high) {
                swap(nums, i, highPos);
                highPos--;
            } else {
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
        int[] nums = {4,3,4,1,2,3,1,2};
        int low = 3;
        int high = 3;

        LC625 lc625 = new LC625();

        lc625.partition2(nums, low, high);

        for (int i : nums) {
            System.out.println(i);
        }
    }
}
