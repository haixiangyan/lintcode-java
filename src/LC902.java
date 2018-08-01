import java.util.Stack;

public class LC902 {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curNode = root;
        while (curNode != null) {
            stack.push(curNode);
            curNode = curNode.left;
        }

        for (int i = 0; i < k - 1; i++) {
            TreeNode node = stack.peek();

            if (node.right == null) {
                node = stack.pop();
                while (!stack.isEmpty() && stack.peek().right == node) {
                    node = stack.pop();
                }
            } else {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }

        return stack.peek().val;
    }
}
