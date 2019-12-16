package com.onefit.Lists;

public class LoopDetection {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.Next = new ListNode(2);
        head1.Next.Next = new ListNode(3);
        head1.Next.Next.Next = new ListNode(3);
        head1.Next.Next.Next.Next = new ListNode(4);
        head1.Next.Next.Next.Next.Next = head1.Next.Next.Next;

        ListNode loop =  IsLoop(head1);

        assert loop == head1.Next.Next.Next;
    }

    private static ListNode IsLoop(ListNode head1) {
        ListNode slow = head1;
        ListNode fast = head1;

        while (fast != null && fast.Next != null) {

            slow = slow.Next;
            fast = fast.Next.Next;
            if (fast == slow) {
                break;
            }
        }

        if (fast == null) {
            return null;
        }

        slow = head1;
        while (slow != fast) {
            slow = slow.Next;
            fast = fast.Next;
        }

        return slow;
    }
}
