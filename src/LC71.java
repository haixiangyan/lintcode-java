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

        Stack<TreeNode> curLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        Stack<TreeNode> temp;
        boolean isNormal = true;

        curLevel.push(root);

        while (!curLevel.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            while (!curLevel.isEmpty()) {
                TreeNode curNode = curLevel.pop();

                list.add(curNode.val);

                if (isNormal) {
                    if (curNode.left != null) {
                        nextLevel.push(curNode.left);
                    }
                    if (curNode.right != null) {
                        nextLevel.push(curNode.right);
                    }
                }
                else {
                    if (curNode.right != null) {
                        nextLevel.push(curNode.right);
                    }
                    if (curNode.left != null) {
                        nextLevel.push(curNode.left);
                    }
                }
            }

            temp = curLevel;
            curLevel = nextLevel;
            nextLevel = temp;
            results.add(list);
            isNormal = !isNormal;
        }

        return results;
    }
}
