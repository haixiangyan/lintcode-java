import java.util.ArrayList;
import java.util.List;

public class LC11 {
    class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        dfs(root, k1, k2, result);

        return result;
    }

    private void dfs(TreeNode root, int k1, int k2, List<Integer> result) {
        if (root == null) {
            return ;
        }

        if (root.val > k1) {
            dfs(root.left, k1, k2, result);
        }
        if (k1 <= root.val && root.val <= k2) {
            result.add(root.val);
        }
        if (root.val < k2) {
            dfs(root.right, k1, k2, result);
        }
    }
}
