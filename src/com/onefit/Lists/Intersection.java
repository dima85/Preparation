package com.onefit.Lists;

import java.util.HashSet;

public class Intersection {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.Next = new ListNode(2);
        head.Next.Next = new ListNode(3);
        head.Next.Next.Next = new ListNode(4);
        head.Next.Next.Next.Next = new ListNode(3);
        head.Next.Next.Next.Next.Next = new ListNode(2);

        ListNode head1 = new ListNode(1);
        head1.Next = new ListNode(2);
        head1.Next.Next = new ListNode(3);
        head1.Next.Next.Next = new ListNode(3);
        head1.Next.Next.Next.Next = head.Next.Next.Next.Next;
        head1.Next.Next.Next.Next.Next = head.Next.Next.Next.Next.Next;

//        ListNode intersect =  IsIntersection(head, head1);
//        ListNode intersect =  IsIntersectionHashmap(head, head1);

        ListNode intersect =  IsIntersectionLength(head, head1);

        assert intersect == head1.Next.Next.Next.Next;
    }

    private static ListNode IsIntersectionLength(ListNode head, ListNode head1) {
        int length1= 0;
        int length2 = 0;
        ListNode cur1 = head;
        ListNode cur2 = head;
        ListNode tail1 = null;
        ListNode tail2 = null;
        while (cur1 != null || cur2 != null) {
            if (cur1 != null) {
                if (cur1.Next == null) {
                    tail1 = cur1;
                }
                cur1 = cur1.Next;
                length1++;
            }
            if (cur2 != null) {
                if (cur2.Next == null) {
                    tail2 = cur2;
                }
                cur2 = cur2.Next;
                length2++;
            }
        }
        if (tail1 != tail2) {
            return null;
        }
        cur1 = head;
        cur2 = head1;
        if (length1 > length2) {
            while (length1 > length2) {
                cur1 = cur1.Next;
                length1 --;
            }
        } else if (length2 > length1) {
            while (length2 > length1) {
                cur2 = cur2.Next;
                length2 --;
            }
        }
        while (cur1 != null) {
            if (cur1 == cur2) {
                return cur1;
            }
            cur1 = cur1.Next;
            cur2 = cur2.Next;
        }
        return null;
    }

    private static ListNode IsIntersectionHashmap(ListNode head, ListNode head1) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            set.add(cur);
            cur = cur.Next;
        }
        cur = head1;
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            }
            cur = cur.Next;
        }
        return null;
    }

    private static ListNode IsIntersection(ListNode head, ListNode head1) {
        ListNode cur1 = head;
        while (cur1 != null) {
            ListNode cur2 = head1;
            while(cur2 != null) {
                if (cur1 == cur2) {
                    return cur2;
                }
                cur2 = cur2.Next;
            }
            cur1 = cur1.Next;
        }
        return null;
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
