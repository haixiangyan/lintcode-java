public class LC200 {

    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }

        int longest = 0;
        int start = 0;
        int curtLongest = 0;

        for (int i = 0; i < s.length(); i++) {
            curtLongest = findLongestPalindrome(s, i, i);
            if (curtLongest > longest) {
                longest = curtLongest;
                start = i - curtLongest / 2;
            }

            curtLongest = findLongestPalindrome(s, i, i + 1);
            if (curtLongest > longest) {
                longest = curtLongest;
                start = i - curtLongest / 2 + 1;
            }
        }

        return s.substring(start, start + longest);
    }

    private int findLongestPalindrome(String s, int left, int right) {
        int len = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }

            len = len + ((left == right) ? 1 : 2);

            left--;
            right++;
        }
        return len;
    }
}