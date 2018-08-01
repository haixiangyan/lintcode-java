import java.util.ArrayList;
import java.util.List;

public class LC691 {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    ArrayList<TreeNode> order = new ArrayList<>();
    public TreeNode bstSwappedNode(TreeNode root) {
        // write your code here
        if (root == null) {
            return null;
        }
        findOrder(root);
        if (order.size() == 1) {
            return root;
        }
        int pre = -1,post = -1;
        int flag = 0;
        for (int i = 0; i < order.size() - 1; i ++) {
            if (order.get(i).val > order.get(i + 1).val) {
                if (flag == 0) {
                    pre = i;
                    flag = 1;
                } else {
                    post = i + 1;
                }
            }
        }
        if (pre == -1) {
            return root;
        }
        if (post == -1) {
            post = pre + 1;
        }
        swap(order.get(pre), order.get(post));
        return root;
    }
    public void findOrder(TreeNode root) {
        if (root != null) {
            findOrder(root.left);
            order.add(root);
            findOrder(root.right);
        }
    }
    public void swap(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}
