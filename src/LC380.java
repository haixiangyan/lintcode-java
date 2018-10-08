public class LC380 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headA.next == null) {
            return null;
        }

        ListNode node = headA;
        while (node.next != null) {
            node = node.next;
        }

        // Link C and B
        node.next = headB;
        ListNode result = findEntrance(headA);
        node.next = null;
        return result;
    }

    private ListNode findEntrance(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            // No cycle
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = head;
        fast = fast.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
