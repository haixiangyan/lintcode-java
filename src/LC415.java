public class LC415 {

    public boolean isPalindrome(String s) {
        // Check validation
        if (s == null) {
            return false;
        }

        if (s.equals("")) {
            return true;
        }

        // Preprocess character
        String newStr = preprocess(s);

        // Check validation
        int strLen = newStr.length();
        int mid = strLen / 2;
        int left = mid - 1;
        int right = strLen % 2 == 0 ? mid : mid + 1;

        while (0 <= left && right < strLen) {
            if (newStr.charAt(left) != newStr.charAt(right)) {
                return false;
            }

            left --;
            right ++;
        }

        return true;
    }

    private String preprocess(String s) {
        // Ignore cases
        String newStr = s.toLowerCase();

        // Remove invalid character
        newStr = newStr.replaceAll("[^\\d\\w]", "");

        System.out.println(newStr);
        return newStr;
    }

    public static void main(String[] args) {
        String str = "aaaa";

        LC415 lc415 = new LC415();

        System.out.println(lc415.isPalindrome(str));
    }
}
