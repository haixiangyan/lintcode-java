import java.util.ArrayList;
import java.util.List;

public class LC34 {
    private int num;

    public int totalNQueens(int n) {
        if (n == 0) {
            return 0;
        }

        search(n, new ArrayList<>());

        return num;
    }

    private void search(int n, List<Integer> solution) {
        if (solution.size() == n) {
            num++;
            return;
        }

        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!isValid(solution, colIndex)) {
                continue;
            }

            solution.add(colIndex);
            search(n, solution);
            solution.remove(solution.size() - 1);
        }
    }

    private boolean isValid(List<Integer> solution, int colIndex) {
        int rows = solution.size();
        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            if (solution.get(rowIndex) == colIndex) {
                return false;
            }
            if (rowIndex + solution.get(rowIndex) == rows + colIndex) {
                return false;
            }
            if (rowIndex - solution.get(rowIndex) == rows - colIndex) {
                return false;
            }
        }
        return true;
    }
}
