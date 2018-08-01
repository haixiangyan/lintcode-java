import java.util.HashSet;

public class LC689 {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    private int[] ans;

    public int[] twoSum(TreeNode root, int n) {
        if (root == null) {
            return new int[0];
        }

        HashSet<Integer> set = new HashSet<>();

        helper(root, n, set);

        return ans;
    }

    private void helper(TreeNode root, int n, HashSet<Integer> set) {
        if (root == null) {
            return;
        }
        if (ans != null) {
            return;
        }

        helper(root.left, n, set);
        if (set.contains(n - root.val)) {
            ans = new int[]{root.val, n - root.val};
            return;
        }
        else {
            set.add(root.val);
        }
        helper(root.right, n, set);
    }
}
