import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC71 {
    class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();

        if (root == null) {
            return results;
        }

        Stack<TreeNode> curStack = new Stack<>();
        Stack<TreeNode> nextStack = new Stack<>();
        Stack<TreeNode> temp;
        boolean isLeftToRight = true;

        curStack.push(root);

        while (!curStack.isEmpty()) {
            int size = curStack.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curNode = curStack.pop();
                level.add(curNode.val);

                if (isLeftToRight) {
                    if (curNode.left != null) {
                        nextStack.push(curNode.left);
                    }
                    if (curNode.right != null) {
                        nextStack.push(curNode.right);
                    }
                }
                else {
                    if (curNode.right != null) {
                        nextStack.push(curNode.right);
                    }
                    if (curNode.left != null) {
                        nextStack.push(curNode.left);
                    }
                }
            }
            results.add(level);
            isLeftToRight = !isLeftToRight;
            // Exchange 2 stacks
            temp = curStack;
            curStack = nextStack;
            nextStack = temp;
        }

        return results;
    }
}
