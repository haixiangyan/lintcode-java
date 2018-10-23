import java.util.*;

public class LC242 {
    class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public List<ListNode> binaryTreeToLists(TreeNode root) {
        List<ListNode> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        ListNode dummy = new ListNode(0);
        ListNode lastNode = null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            dummy.next = null;
            lastNode = dummy;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                lastNode.next = new ListNode(curNode.val);
                lastNode = lastNode.next;

                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }

            results.add(dummy.next);
        }

        return results;
    }
}
