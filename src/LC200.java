public class LC200 {

    public String longestPalindrome(String s) {
        String curStr = "";
        int maxLen = 0;
        int strLen;
        int left = 0, right = 0;
        int curLeft = 0, curRight = 0;

        // Check empty string
        if (s == null || s.equals("")) {
            return "";
        }

        // Get string length
        strLen = s.length();

        for (int mid = 0 ; mid < strLen ; mid++) {
            // For odd length case
            for (left = mid - 1, right = mid + 1 ; left >= 0 && right < strLen ; left --, right ++) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }

                if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    curLeft = left;
                    curRight = right;
                }
            }

            // For even length case
            for (left = mid, right = mid + 1 ; left >= 0 && right < strLen ; left--, right ++) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }

                if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    curLeft = left;
                    curRight = right;
                }
            }
        }

        curStr = s.substring(curLeft, curRight + 1);

        return curStr;
    }

    public static void main(String[] args) {
        String str = "abcdzdcab";

        LC200 lc200 = new LC200();

        System.out.println(lc200.longestPalindrome(str));
    }
}