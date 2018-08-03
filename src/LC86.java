import java.util.Stack;

public class LC86 {

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    private Stack<TreeNode> stack;

    public LC86(TreeNode root) {
        stack = new Stack<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.empty();
    }

    public TreeNode next() {
        TreeNode curt = stack.peek();
        TreeNode node = curt;

        if (node.right != null) {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        } else {
            node = stack.pop();
            while (!stack.isEmpty() && stack.peek().right == node) {
                node = stack.pop();
            }
        }

        return curt;
    }
}