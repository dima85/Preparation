package com.onefit.Lists;

import java.util.Stack;

public class IsPalindrom {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.Next = new ListNode(2);
        head.Next.Next = new ListNode(3);
        head.Next.Next.Next = new ListNode(4);
        head.Next.Next.Next.Next = new ListNode(3);
        head.Next.Next.Next.Next.Next = new ListNode(2);
        head.Next.Next.Next.Next.Next.Next = new ListNode(1);

        ListNode head1 = new ListNode(1);
        head1.Next = new ListNode(2);
        head1.Next.Next = new ListNode(3);
        head1.Next.Next.Next = new ListNode(3);
        head1.Next.Next.Next.Next = new ListNode(2);
        head1.Next.Next.Next.Next.Next = new ListNode(1);

        boolean isPalindromList =  CheckIsPalindrom(head);
        boolean isPalindromListRev =  CheckIsPalindromReverse(head);
        boolean isPalindromListStack =  CheckIsPalindromStack(head1);

        //assert isPalindromList;
        //assert isPalindromListRev;
        assert isPalindromListStack;
    }

    private static boolean CheckIsPalindromStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        ListNode cur = head;
        ListNode runner = head;
        //1->2->3->4->3->2->1
        //1->2->3->3->2->1
        while (runner != null && runner.Next != null) {
            stack.push(cur.Value);
            cur = cur.Next;
            runner = runner.Next.Next;
        }
        if (runner != null) {
            cur = cur.Next;
        }
        while (cur != null) {
            if (stack.pop() != cur.Value) {
                return false;
            }
            cur = cur.Next;
        }

        return stack.empty();
    }

    private static boolean CheckIsPalindromReverse(ListNode head) {
        ListNode reverse = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode node = new ListNode(cur.Value);
            if (reverse == null) {
                reverse = node;
            } else {
                node.Next = reverse;
                reverse = node;
            }
            cur = cur.Next;
        }

        cur = head;
        ListNode rev = reverse;
        while (cur != null) {
            if (cur.Value != rev.Value) {
                return false;
            }
            cur = cur.Next;
            rev = rev.Next;
        }
        return true;
    }

    private static boolean CheckIsPalindrom(ListNode head) {
        boolean result = true;
         //1->2->3->3->2->1

        ListNode first = head;
        ListNode last = head;
        while (last.Next != null) {
            last = last.Next;
        }
        while (first != last) {
            if (first.Value != last.Value) {
                return false;
            }
            if (first.Next == last) {
                break;
            }

            ListNode cur = first;
            while (cur.Next != last) {
                cur = cur.Next;
            }
            last = cur;
            first = first.Next;
        }

        return result;
    }
}
