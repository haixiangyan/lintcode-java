import java.util.ArrayList;
import java.util.List;

public class LC66 {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
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

        // Mark this node
        result.add(root.val);

        // Traversal right
        dfs(root.left, result);
        dfs(root.right, result);

        return result;
    }
}
