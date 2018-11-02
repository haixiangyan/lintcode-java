import java.util.ArrayList;
import java.util.List;

public class LC453 {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public void flatten(TreeNode root) {
        divideConquer(root);
    }

    private TreeNode divideConquer(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftLastNode = divideConquer(root.left);
        TreeNode rightLastNode = divideConquer(root.right);

        if (leftLastNode != null) {
            leftLastNode.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        if (rightLastNode != null) {
            return rightLastNode;
        }
        if (leftLastNode != null) {
            return leftLastNode;
        }

        return root;
    }
}
