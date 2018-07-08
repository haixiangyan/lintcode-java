public class LC103 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode intersection = chase(head);
        // No cycle
        if (intersection == null) {
            return null;
        }

        ListNode line = head;
        ListNode cycle = intersection;

        while (line != cycle) {
            line = line.next;
            cycle = cycle.next;
        }

        return line;
    }

    private ListNode chase(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return fast;
            }
        }

        return null;
    }
}
