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
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<ListNode> lists = new ArrayList<>();

        queue.offer(root);

        ListNode dummy = new ListNode(0);
        ListNode lastNode = null;

        while (!queue.isEmpty()) {
            int size = queue.size();

            dummy.next = null;
            lastNode = dummy;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                lastNode.next = new ListNode(node.val);
                lastNode = lastNode.next;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // Add this list to collection
            lists.add(dummy.next);
        }

        return lists;
    }
}
