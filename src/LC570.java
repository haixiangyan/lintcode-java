public class LC570 {
    private int theMissing;

    public int findMissing2(int n, String str) {
        theMissing = -1;
        boolean[] isFound = new boolean[n + 1];

        dfs(n, 0, str, isFound);

        return theMissing;
    }

    private void dfs(int n, int index, String str, boolean[] isFound) {
        if (theMissing != -1) {
            return;
        }

        if (index == str.length()) {
            for (int i = 1; i < isFound.length; i++) {
                if (!isFound[i]) {
                    theMissing = i;
                    return;
                }
            }

            return;
        }

        if (str.charAt(index) == '0') {
            return;
        }

        for (int ch = 1; ch <= 2 && index + ch <= str.length(); ch ++) {
            int num = Integer.parseInt(str.substring(index, index + ch));
            if (0 < num && num <= n && !isFound[num]) {
                isFound[num] = true;
                dfs(n, index + ch, str, isFound);
                isFound[num] = false;
            }
        }
    }
}
