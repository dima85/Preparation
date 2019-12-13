package com.onefit.Lists;

public class Partitioning {

    public static void main(String[] pars) {
        ListNode head = new ListNode(3);
        head.Next = new ListNode(5);
        head.Next.Next = new ListNode(8);
        head.Next.Next.Next = new ListNode(5);
        head.Next.Next.Next.Next = new ListNode(10);
        head.Next.Next.Next.Next.Next = new ListNode(1);

        ListNode res1 = new ListNode(3);
        res1.Next = new ListNode(1);
        res1.Next.Next = new ListNode(5);
        res1.Next.Next.Next = new ListNode(8);
        res1.Next.Next.Next.Next = new ListNode(5);
        res1.Next.Next.Next.Next.Next = new ListNode(10);

        ListNode newHead =  Partition(head, 5);

        assert AreEqual(head, res1);
    }

    private static ListNode Partition(ListNode head, int value) {
        ListNode newHead = head;
        ListNode tail = head;
        while (head != null)
        {
            ListNode next = head.Next;
            if (head.Value < value) {
                head.Next = newHead;
                newHead = head;
            }
            if (head.Value >= value) {
                newHead.Next = head;
            }
            head = head.Next;
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
