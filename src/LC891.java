public class LC891 {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left++;
            right--;
        }

        return isSubPalindrome(s, left + 1, right) || isSubPalindrome(s, left, right - 1);
    }

    private boolean isSubPalindrome(String s, int left, int right) {
        int subLeft = left, subRight = right;
        while (subLeft < subRight) {
            if (s.charAt(subLeft) != s.charAt(subRight)) {
                return false;
            }
            subLeft++;
            subRight--;
        }

        return true;
    }
}
