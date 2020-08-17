package leetcode;

public class ComplexList {
    private static class ListNode {
        int val;
        ListNode random;
        ListNode next;
    }

    static ListNode copy(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur;

        cur = head;
        while (cur != null) {
            ListNode newNode = new ListNode();
            newNode.val = cur.val;

            newNode.next = cur.next;
            cur.next = newNode;

            cur = newNode.next;
        }

        cur = head;
        while (cur != null) {
            ListNode newNode = cur.next;
            if (cur.random != null) {
                newNode.random = cur.random.next;
            }

            cur = newNode.next;
        }

        cur = head;
        ListNode result = head.next;
        while (cur != null) {
            ListNode newNode = cur.next;
            cur.next = newNode.next;
            if (newNode.next != null) {
                newNode.next = newNode.next.next;
            }

            cur = cur.next;
        }
        return result;
    }
}
