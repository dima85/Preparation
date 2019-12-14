package com.onefit.Lists;

public class SumLists {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.Next = new ListNode(2);
        head.Next.Next = new ListNode(6);
        head.Next.Next.Next = new ListNode(4);

        ListNode head1 = new ListNode(3);
        head1.Next = new ListNode(4);
        head1.Next.Next = new ListNode(5);

        ListNode res = new ListNode(4);
        res.Next = new ListNode(6);
        res.Next.Next = new ListNode(1);
        res.Next.Next.Next = new ListNode(5);

        ListNode resRev = new ListNode(1);
        resRev.Next = new ListNode(6);
        resRev.Next.Next = new ListNode(0);
        resRev.Next.Next.Next = new ListNode(9);

        ListNode newHead =  Sum(head, head1);

        assert AreEqual(newHead, res);

        ListNode newHeadReverse =  SumReverse(head, head1);

        assert AreEqual(newHeadReverse, resRev);
    }

    public static int getLength(ListNode head1) {
        int result = 0;
        while (head1 != null) {
            result ++;
            head1 = head1.Next;
        }
        return result;
    }

    public static ListNode pad(ListNode head, int number) {
        ListNode newHead = head;
        while (number > 0) {
            ListNode zero = new ListNode(0);
            zero.Next = newHead;
            newHead = zero;
            number--;
        }
        return newHead;
    }

    public static class ListNodeWithLeftOver {
        public int LeftOver;
        public ListNode Head;
        public ListNodeWithLeftOver(int leftOver) {
            LeftOver = leftOver;
        }
    }

    public static ListNode SumReverse(ListNode head1, ListNode head2) {
        int length1 = getLength(head1);
        int length2 = getLength(head2);

        if (length1 > length2) {
            head2 = pad(head2, length1 - length2);
        } else if (length2 > length1) {
            head1 = pad(head1, length2 - length1);
        }

        ListNodeWithLeftOver result = SumAndReturnLeftover(head1, head2);
        ListNode newHead = result.Head;
        if (result.LeftOver > 0) {
            newHead = new ListNode(result.LeftOver);
            newHead.Next = result.Head;
        }
        return newHead;
    }

    public static ListNodeWithLeftOver SumAndReturnLeftover(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) {
            return new ListNodeWithLeftOver(0);
        }

        ListNodeWithLeftOver nextSum = SumAndReturnLeftover(head1.Next, head2.Next);

        int res = head1.Value + head2.Value + nextSum.LeftOver;
        int left = 0;
        if (res > 9) {
            left = res / 10;
            res = res % 10;
        }
        ListNodeWithLeftOver result = new ListNodeWithLeftOver(left);
        ListNode node = new ListNode(res);
        node.Next = nextSum.Head;
        result.Head = node;

        return result;
    }

    public static ListNode Sum(ListNode head1, ListNode head2) {
        int leftOver = 0;
        ListNode sumHead = null;
        ListNode cur = null;
        while (head1 != null || head2 != null || leftOver > 0) {
            int val1 = head1 != null ? head1.Value : 0;
            int val2 = head2 != null ? head2.Value : 0;
            int sum = val1 + val2 + leftOver;

            if (sum > 9) {
                leftOver = sum / 10;
                sum = sum % 10;
            }
            else {
                leftOver = 0;
            }

            if (sumHead == null) {
                sumHead = new ListNode(sum);
                cur = sumHead;
            } else {
                ListNode tmp = new ListNode(sum);
                cur.Next = tmp;
                cur = cur.Next;
            }

            if (head1 != null) head1 = head1.Next;
            if (head2 != null) head2 = head2.Next;
        }
        return sumHead;
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
