import java.util.ArrayList;
import java.util.List;

public class LC33 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();

        if (n == 0) {
            return results;
        }

        search(n, new ArrayList<>(), results);

        return results;
    }

    private void search(int n, List<Integer> cols, List<List<String>> results) {
        if (cols.size() == n) {
            results.add(drawBoard(cols, n));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!isValid(cols, col)) {
                continue;
            }
            cols.add(col);
            search(n, cols, results);
            cols.remove(cols.size() - 1);
        }
    }

    private List<String> drawBoard(List<Integer> cols, int n) {
        List<String> board = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            int queen = cols.get(i);
            for (int j = 0; j < n; j++) {
                sb.append((j == queen) ? "Q" : ".");
            }
            board.add(sb.toString());
        }

        return board;
    }

    private boolean isValid(List<Integer> cols, int colIndex) {
        int rows = cols.size();
        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            if (cols.get(rowIndex) == colIndex) {
                return false;
            }
            if (rowIndex + cols.get(rowIndex) == rows + colIndex) {
                return false;
            }
            if (rowIndex - cols.get(rowIndex) == rows - colIndex) {
                return false;
            }
        }

        return true;
    }
}
