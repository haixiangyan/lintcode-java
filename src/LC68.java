import java.util.ArrayList;
import java.util.List;

public class LC68 {
    class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> result = new ArrayList<>();

        return dfs(root, result);
    }

    private List<Integer> dfs(TreeNode root, List<Integer> result) {
        if (root == null) {
            return null;
        }

        dfs(root.left, result);
        dfs(root.right, result);
        result.add(root.val);

        return result;
    }
}
