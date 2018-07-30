import java.util.ArrayList;
import java.util.List;

public class LC67 {
    class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> result = new ArrayList<>();

        return dfs(root, result);
    }

    public List<Integer> dfs(TreeNode root, List<Integer> result) {
        if (root == null) {
            return null;
        }

        dfs(root.left, result);
        result.add(root.val);
        dfs(root.right, result);

        return result;
    }
}
