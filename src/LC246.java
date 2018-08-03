import java.util.ArrayList;
import java.util.List;

public class LC246 {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        helper(root, target, new ArrayList<>(), result);
        return result;
    }

    private void helper(TreeNode root, int target, List<Integer> buffer, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        buffer.add(root.val);

        int sum = 0;
        for (int i = buffer.size() - 1; i >= 0; i--) {
            sum = sum + buffer.get(i);
            if (sum == target) {
                result.add(new ArrayList<>(buffer.subList(i, buffer.size())));
            }
        }

        helper(root.left, target, buffer, result);
        helper(root.right, target, buffer, result);
        buffer.remove(buffer.size() - 1);
    }
}
