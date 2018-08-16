public class LC154 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        boolean[][] visited = new boolean[s.length()][p.length()];
        boolean[][] memo = new boolean[s.length()][p.length()];

        return isMatchHelper(s, p, 0, 0, visited, memo);
    }

    private boolean isMatchHelper(String s, String p, int sIndex, int pIndex, boolean[][] visited, boolean[][] memo) {
        if (pIndex == p.length()) {
            return sIndex == s.length();
        }
        if (sIndex == s.length()) {
            return isAllStar(p, pIndex);
        }

        if (visited[sIndex][pIndex]) {
            return memo[sIndex][pIndex];
        }

        char sChar = s.charAt(sIndex);
        char pChar = p.charAt(pIndex);
        boolean match;

        if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
            match = isMatchHelper(s, p, sIndex, pIndex + 2, visited, memo)
                    || matchChar(sChar, pChar)
                    && isMatchHelper(s, p, sIndex + 1, pIndex, visited, memo);
        }
        else {
            match = matchChar(sChar, pChar)
                    && isMatchHelper(s, p, sIndex + 1, pIndex + 1, visited, memo);
        }

        visited[sIndex][pIndex] = true;
        memo[sIndex][pIndex] = match;

        return match;
    }

    private boolean matchChar(char sChar, char pChar) {
        return (sChar == pChar || pChar == '.');
    }

    private boolean isAllStar(String p, int pIndex) {
        for (int i = pIndex; i < p.length(); i = i + 2) {
            if (i + 1 >= p.length() || p.charAt(i + 1) != '*') {
                return false;
            }
        }
        return true;
    }
}
