import java.util.Arrays;

public class LC382 {
    public int triangleCount(int[] S) {
        if (S == null || S.length < 3) {
            return 0;
        }

        Arrays.sort(S);

        int count = 0;
        for (int i = 0; i < S.length; i++) {
            count = count + twoSumLarge(S, 0, i - 1, S[i]);
        }

        return count;
    }

    private int twoSumLarge(int[] S, int start, int end, int target) {
        int left = start, right = end;
        int count = 0;
        while (left < right) {
            if (S[left] + S[right] > target) {
                count = count + (right - left);
                right--;
            }
            else {
                left++;
            }
        }
        return count;
    }
}
