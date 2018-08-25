public class LC123 {
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, -1, 0, 1};

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                visited[i][j] = true;
                boolean isExist = dfs(board, visited, word, String.valueOf(board[i][j]), i, j);

                if (isExist) {
                    return true;
                }
                visited[i][j] = false;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, String word, String comparedWord, int i, int j) {
        if (compare(word, comparedWord) == 1) {
            return true;
        }
        if (compare(word, comparedWord) == 0) {
            return false;
        }

        for (int m = 0; m < 4; m++) {
            int x1 = dx[m] + i;
            int y1 = dy[m] + j;

            if (!isBound(board, x1, y1) || visited[x1][y1]) {
                continue;
            }

            visited[x1][y1] = true;

            StringBuffer sb = new StringBuffer();
            sb.append(comparedWord);
            sb.append(String.valueOf(board[x1][y1]));

            if (dfs(board, visited, word, sb.toString(), x1, y1)) {
                return true;
            }

            visited[x1][y1] = false;
        }

        return false;
    }

    private boolean isBound(char[][] board, int i, int j) {
        return (0 <= i && i < board.length) && (0 <= j && j < board[0].length);
    }

    private int compare(String word, String comparedWord) {
        if (word.equals(comparedWord)) {
            return 1;
        }
        if (word.startsWith(comparedWord)) {
            return 2;
        }
        return 0;
    }
}
