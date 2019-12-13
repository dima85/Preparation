package com.onefit.Lists;

import java.util.HashSet;

public class RemoveDups {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.Next = new ListNode(2);
        head.Next.Next = new ListNode(2);
        head.Next.Next.Next = new ListNode(3);
        head.Next.Next.Next.Next = new ListNode(3);
        head.Next.Next.Next.Next.Next = new ListNode(4);

        RemoveAllDups(head);

        ListNode headRes = new ListNode(1);
        headRes.Next = new ListNode(2);
        headRes.Next.Next = new ListNode(3);
        headRes.Next.Next.Next = new ListNode(4);
        //headRes.Next.Next.Next.Next = new ListNode(4);
        assert AreEqual(head, headRes);
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

    public static void RemoveAllDups(ListNode head) {
        ListNode cur = head;
        ListNode run = null;
        ListNode prev = null;

        while (cur != null) {
            run = cur.Next;
            prev = cur;
            while (run != null) {
                if (cur.Value == run.Value) {
                    prev.Next = run.Next;
                } else {
                    prev = run;
                }
                run = run.Next;
            }
            cur = cur.Next;
        }
    }

    public static void RemoveAllDups_hs(ListNode head) {
        HashSet<Integer> map = new HashSet<>();
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            if (map.contains(cur.Value)) {
                prev.Next = cur.Next;
            }
            else {
                map.add(cur.Value);
                prev = cur;
            }
            cur = cur.Next;
        }
    }
}
