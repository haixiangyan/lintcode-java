import java.util.*;

public class LC132 {
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, -1, 0, 1};

    public List<String> wordSearchII(char[][] board, List<String> words) {
        Map<String, Boolean> prefiexSet = getPrefiexSet(words);
        Set<String> results = new HashSet<>();

        if (words.size() == 0) {
            return new ArrayList<>();
        }

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i =0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                visited[i][j] = true;
                search(board, visited, i, j, String.valueOf(board[i][j]), prefiexSet, results);
                visited[i][j] = false;
            }
        }

        return new ArrayList<>(results);
    }

    private void search(
            char[][] board,
            boolean[][] visited,
            int x,
            int y,
            String word,
            Map<String, Boolean> prefiexSet,
            Set<String> results) {
        if (!prefiexSet.containsKey(word)) {
            return;
        }
        if (prefiexSet.get(word)) {
            results.add(word);
        }

        for (int m = 0; m < 4; m++) {
            int x1 = x + dx[m];
            int y1 = y + dy[m];

            if (!isBound(board, x1, y1) || visited[x1][y1]) {
                continue;
            }

            visited[x1][y1] = true;
            search(board, visited, x1, y1, word + board[x1][y1], prefiexSet, results);
            visited[x1][y1] = false;
        }
    }

    private Map<String, Boolean> getPrefiexSet(List<String> words) {
        Map<String, Boolean> prefixSet = new HashMap<>();

        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                String temp = s.substring(0, i + 1);
                if (!prefixSet.containsKey(temp)) {
                    prefixSet.put(temp, false);
                }
                if (temp.equals(s)) {
                    prefixSet.put(temp, true);
                }
            }
        }

        return prefixSet;
    }

    private boolean isBound(char[][] board, int x, int y) {
        return (0 <= x && x < board.length) && (0 <= y && y < board[0].length);
    }
}
