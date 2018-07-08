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
        if (headA == null || headB == null) {
            return null;
        }
        // Link the end of c with headb
        cycle(headA, headB);
        // Find the intersection point
        ListNode intersection = chase(headA);
        // No cycle
        if (intersection == null) {
            return null;
        }
        // Find the entrance
        return findEntrance(headA, intersection);
    }

    private void cycle(ListNode headA, ListNode headB) {
        ListNode p = headA;

        while (p.next != null) {
            p = p.next;
        }

        // Find the end of linked list c
        p.next = headB;
    }

    private ListNode chase(ListNode headA) {
        ListNode slow = headA;
        ListNode fast = headA;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return fast;
            }
        }

        return null;
    }

    private ListNode findEntrance(ListNode line, ListNode cycle) {
        while (line != cycle) {
            line = line.next;
            cycle = cycle.next;
        }

        return line;
    }
}
