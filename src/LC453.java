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

    class ResultType {
        public TreeNode head;
        public TreeNode tail;

        public ResultType(TreeNode head, TreeNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public void flatten(TreeNode root) {
        helper(root);
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return null;
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        root.left = null;

        if (left != null && right == null) {
            root.right = left.head;
            return new ResultType(root, left.tail);
        }

        if (right != null && left == null) {
            return new ResultType(root, right.tail);
        }

        if (left != null && right != null) {
            root.right = left.head;
            left.tail.right = right.head;

            return new ResultType(root, right.tail);
        }

        return new ResultType(root, root);
    }
}
