public class LC192 {
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
            return allStar(p, pIndex);
        }

        if (visited[sIndex][pIndex]) {
            return memo[sIndex][pIndex];
        }

        char sChar = s.charAt(sIndex);
        char pChar = p.charAt(pIndex);
        boolean isMatch = false;

        if (pChar == '*') {
            isMatch = isMatchHelper(s, p, sIndex, pIndex + 1, visited, memo)
                    || isMatchHelper(s, p, sIndex + 1, pIndex, visited, memo);
        }
        else {
            isMatch = isCharMatch(sChar, pChar)
                    && isMatchHelper(s, p, sIndex + 1, pIndex + 1, visited, memo);
        }

        visited[sIndex][pIndex] = true;
        memo[sIndex][pIndex] = isMatch;
        return isMatch;
    }

    private boolean isCharMatch(char sChar, char pChar) {
        return (sChar == pChar || pChar == '?');
    }

    private boolean allStar(String p, int pIndex) {
        for (int i = pIndex; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }

        return true;
    }
}
