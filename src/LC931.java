public class LC931 {
    public double findMedian(int[][] nums) {
        int n = getTotalLength(nums);

        if (n == 0) {
            return 0.0;
        }

        if (n % 2 != 0) {
            return findKth(nums, n / 2 + 1);
        }

        return findKth(nums, n / 2) / 2.0 + findKth(nums, n / 2 + 1) / 2.0;
    }

    public int getTotalLength(int[][] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            len += nums[i].length;
        }

        return len;
    }

    public int findKth(int[][] nums, int k) {
        int start = 0, end = Integer.MAX_VALUE;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // Too small -> Too much nums are greater than mid
            if (getGTE(nums, mid) >= k) {
                start = mid;
            }
            else {
                end = mid;
            }
        }

        if (getGTE(nums, start) >= k) {
            return start;
        }

        return end;
    }

    public int getGTE(int[][] nums, int val) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += getGTE(nums[i], val);
        }

        return sum;
    }

    public int getGTE(int[] numsRow, int val) {
        if (numsRow == null || numsRow.length == 0) {
            return 0;
        }

        int start = 0, end = numsRow.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (numsRow[mid] >= val) {
                end = mid;
            }
            else {
                start = mid;
            }
        }

        if (numsRow[start] >= val) {
            return numsRow.length - start;
        }
        if (numsRow[end] >= val) {
            return numsRow.length - end;
        }

        return 0;
    }
}
