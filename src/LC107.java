import java.util.Set;

public class LC107 {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s.length() == 0) {
            return true;
        }
        if (dict.size() == 0) {
            return false;
        }

        int maxLen = getMaxLength(dict);

        boolean[] canbreak = new boolean[s.length() + 1];
        canbreak[0] = true;

        for (int i = 1; i < canbreak.length; i++) {
            for (int j = 1; j <= maxLen && j <= i; j++){
                String word = s.substring(i - j, i);
                if (dict.contains(word) && canbreak[i - j]) {
                    canbreak[i] = true;
                    break;
                }
            }
        }

        return canbreak[canbreak.length - 1];
    }

    private int getMaxLength(Set<String> dict) {
        int maxLen = 0;

        for (String s : dict) {
            maxLen = Math.max(maxLen, s.length());
        }

        return maxLen;
    }


    public boolean wordBreakMemoryExceed(String s, Set<String> dict) {
        if (dict.size() == 0) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }

        return helper(s, dict);
    }

    private boolean helper(String s, Set<String> dict) {
        if (dict.contains(s)) {
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            if (dict.contains(s.substring(0, i))) {
                if (helper(s.substring(i), dict)) {
                    return true;
                }
            }
        }

        return false;
    }
}
