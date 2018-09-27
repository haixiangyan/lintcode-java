import java.util.*;

public class LC627 {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            }
            else {
                set.add(c);
            }
        }

        int size = set.size();
        if (size > 0) {
            size -= 1;
        }

        return s.length() - size;
    }
}
