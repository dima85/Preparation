package com.onefit.Lists;

public class Partitioning {

    public static void main(String[] pars) {
        ListNode head = new ListNode(3);
        head.Next = new ListNode(15);
        head.Next.Next = new ListNode(8);
        head.Next.Next.Next = new ListNode(5);
        head.Next.Next.Next.Next = new ListNode(4);
        head.Next.Next.Next.Next.Next = new ListNode(1);

        ListNode res1 = new ListNode(1);
        res1.Next = new ListNode(4);
        res1.Next.Next = new ListNode(3);
        res1.Next.Next.Next = new ListNode(15);
        res1.Next.Next.Next.Next = new ListNode(8);
        res1.Next.Next.Next.Next.Next = new ListNode(5);

        ListNode newHead =  Partition(head, 5);

        assert AreEqual(newHead, res1);
    }

    private static ListNode Partition(ListNode head, int value) {
        // 6 7 2 5 1 2 10 7
        ListNode cur = head.Next;
        ListNode prev = null;
        while (cur != null) {
            if (cur.Value < value) {
                prev.Next = cur.Next;
                cur.Next = head;
                head = cur;
                cur = prev.Next;
            }
            else {
                prev = cur;
                cur = cur.Next;
            }
        }
        return head;
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
