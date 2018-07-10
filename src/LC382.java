import java.util.Arrays;

public class LC382 {
    public int triangleCount(int[] S) {
        if (S == null || S.length <= 2) {
            return 0;
        }

        Arrays.sort(S);

        int count = 0;

        for (int i = 0; i < S.length; i++) {
            count = count + twoSum(S, 0, i - 1, S[i]);
        }

        return count;
    }

    private int twoSum(int[] S, int start, int end, int target) {
        int left = start;
        int right = end;
        int count = 0;

        while (left < right) {
            if (S[left] + S[right] > target) {
                count = count + (right - left);
                right--;
            } else {
                left++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] S = {3,4,6,7};

        LC382 lc382 = new LC382();

        System.out.println(lc382.triangleCount(S));
    }
}
