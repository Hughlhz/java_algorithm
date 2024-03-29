package hot100.linkedlist;

import annotations.Star;

@Star("归并排序！！！普通的选择排序和插入排序会超时")
public class Leetcode148 {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        ListNode oldHead = new ListNode(0, head);
        int max;
        ListNode pre=oldHead;
        ListNode maxNodePre;
        ListNode temp;
        while (oldHead.next != null) {
            maxNodePre=oldHead;
            max=maxNodePre.next.val;
            pre=oldHead;

            while (pre.next != null) {
                if (max < pre.next.val) {
                    max=pre.next.val;
                    maxNodePre=pre;
                }
                pre=pre.next;
            }
            //头插

            temp=maxNodePre.next;
            maxNodePre.next=temp.next;
            temp.next=newHead.next;
            newHead.next=temp;


        }
        return newHead.next;

    }
}
