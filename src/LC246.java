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
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> buffer = new ArrayList<>();

        if (root == null) {
            return paths;
        }

        preOrder(root, target, 0, buffer, paths);

        return paths;
    }

    private void preOrder(TreeNode root, int target, int level, List<Integer> buffer, List<List<Integer>> paths) {
        if (root == null) {
            return;
        }

        buffer.add(root.val);

        // Find paths
        int tempTarget = target;
        for (int i = level; i >= 0 ; i--) {
            tempTarget = tempTarget - buffer.get(i);
            if (tempTarget == 0) {
                List<Integer> path = new ArrayList<>();
                for (int j = i; j <= level; j++) {
                    path.add(buffer.get(j));
                }

                paths.add(path);
            }
        }

        // Left and right subtrees
        preOrder(root.left, target, level + 1, buffer, paths);
        preOrder(root.right, target, level + 1, buffer, paths);

        buffer.remove(level);
    }
}
