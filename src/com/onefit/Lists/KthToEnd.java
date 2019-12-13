package com.onefit.Lists;

public class KthToEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.Next = new ListNode(2);
        head.Next.Next = new ListNode(3);
        head.Next.Next.Next = new ListNode(4);
        head.Next.Next.Next.Next = new ListNode(5);
        head.Next.Next.Next.Next.Next = new ListNode(6);

        ListNode res1 = new ListNode(3);
        res1.Next = new ListNode(4);
        res1.Next.Next = new ListNode(5);

        ListNode res =  SubList(head, 2, 4);

        assert AreEqual(res, res1);
    }

    private static ListNode SubList(ListNode head, int start, int end) {
        int index = 0;
        ListNode newHead = null;
        ListNode cur = head;
        while (cur != null &&  index <= end) {
            if (index == start) {
                newHead = cur;
            }
            if (index == end) {
                cur.Next = null;
            }
            cur = cur.Next;
            index++;
        }
        return newHead;
    }

    public static boolean AreEqual(ListNode head1, ListNode head2) {
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        while (cur1 != null || cur2 != null) {
            if (cur1.Value != cur2.Value)
                return false;

            cur1 = cur1.Next;
            cur2 = cur2.Next;
        }
        return true;
    }
}
