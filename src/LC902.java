import java.util.HashMap;

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
        HashMap<TreeNode, Integer> numOfNodes = new HashMap<>();
        countNodes(root, numOfNodes);
        return quickselect(root, k, numOfNodes);
    }

    private int countNodes(TreeNode root, HashMap<TreeNode, Integer> numOfNodes) {
        if (root == null) {
            return 0;
        }

        int left = countNodes(root.left, numOfNodes);
        int right = countNodes(root.right, numOfNodes);

        numOfNodes.put(root, left + right + 1);
        return left + right + 1;
    }

    private int quickselect(TreeNode root, int k , HashMap<TreeNode, Integer> numOfNodes) {
        if (root == null) {
            return -1;
        }

        int left = (root.left == null) ? 0 : numOfNodes.get(root.left);

        if (k <= left) {
            return quickselect(root.left, k, numOfNodes);
        }

        if (left + 1 == k) {
            return root.val;
        }

        return quickselect(root.right, k - left - 1, numOfNodes);
    }
}
