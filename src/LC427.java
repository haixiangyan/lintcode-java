import java.util.ArrayList;
import java.util.List;

public class LC427 {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();

        if (n < 1) {
            return results;
        }

        helper("", n, n, results);

        return results;
    }

    private void helper(String paren, int left, int right, List<String> results) {
        if (left == 0 && right == 0) {
            results.add(paren);
            return;
        }

        if (left > 0) {
            helper(paren + "(", left - 1, right, results);
        }

        if (right > 0 && right > left) {
            helper(paren + ")", left, right - 1, results);
        }
    }

    public static void main(String[] args) {
        LC427 lc427 = new LC427();

        System.out.println(lc427.generateParenthesis(3));
    }
}
