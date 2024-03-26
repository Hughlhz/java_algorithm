package hot100.linkedlist;

import annotations.Star;

@Star("递归比迭代方便很多！！！")
public class Leetcode24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null||head.next==null) {
            return head;
        }
        ListNode temp=head.next;
        head.next=swapPairs(head.next.next);
        temp.next = head;
        return temp;
    }



    public ListNode swapPairs_(ListNode head) {
        ListNode newHead = new ListNode(0, head);
        ListNode pre;
        ListNode cur=newHead;
        ListNode temp;
        while (cur.next != null) {
            if (cur.next.next == null) {
                return newHead.next;
            }
            pre=cur;
            cur=cur.next.next;
            temp=cur.next;
            cur=pre.next;
            pre.next=pre.next.next;
            pre.next.next=cur;
            cur.next=temp;


        }
        return newHead.next;

    }
}
