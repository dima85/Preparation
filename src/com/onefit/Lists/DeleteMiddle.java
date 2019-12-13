package com.onefit.Lists;

public class DeleteMiddle {
    public static void main(String[] pars) {
        ListNode head = new ListNode(1);
        head.Next = new ListNode(2);
        head.Next.Next = new ListNode(3);
        head.Next.Next.Next = new ListNode(4);
        head.Next.Next.Next.Next = new ListNode(5);
        head.Next.Next.Next.Next.Next = new ListNode(6);

        ListNode res1 = new ListNode(1);
        res1.Next = new ListNode(2);
        res1.Next.Next = new ListNode(4);
        res1.Next.Next.Next = new ListNode(5);
        res1.Next.Next.Next.Next = new ListNode(6);

        DeleteMiddleNode(head);

        assert AreEqual(head, res1);
    }

    private static void DeleteMiddleNode(ListNode head) {
        int numberOfElements = 0;
        ListNode cur = head;
        while (cur != null) {
            numberOfElements++;
            cur = cur.Next;
        }
        if (numberOfElements <= 1) {
            return;
        }
        int counter = 0;
        ListNode prevElementToDelete = head;
        while (counter < numberOfElements / 2 - 1 - 1) {
            prevElementToDelete = prevElementToDelete.Next;
            counter ++;
        }
        prevElementToDelete.Next = prevElementToDelete.Next.Next;
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
