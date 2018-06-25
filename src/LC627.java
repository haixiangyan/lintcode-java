import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LC627 {

    public int longestPalindrome(String s) {
        // Check validation
        if (s == null || s.equals("")) {
            return 0;
        }

        HashMap<Character, Integer> charSet = new HashMap<>();
        int total = 0;
        boolean containOdd = false;

        // Count number of each character
        collectCharset(charSet, s);

        // Count odd times and even times
        for (Integer value : charSet.values()) {
            if (value % 2 == 0) {
                total = total + value;
            }
            else {
                containOdd = true;
                total = total + value - 1;
            }
        }

        total = containOdd ? total + 1 : total;

        return total;
    }

    private void collectCharset(HashMap<Character, Integer> charSet, String s) {
        int number;
        char curChar;
        int strLen = s.length();

        for (int i = 0 ; i < strLen ; i++) {
            curChar = s.charAt(i);

            number = charSet.getOrDefault(curChar, 0);

            number = number + 1;

            charSet.put(curChar, number);
        }
    }

    public static void main(String[] args) {
        String str = "abccccdd";

        LC627 lc627 = new LC627();

        System.out.println(lc627.longestPalindrome(str));
    }
}
