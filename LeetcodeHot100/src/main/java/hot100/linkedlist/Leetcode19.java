package hot100.linkedlist;

import annotations.Star;

@Star("增加虚拟头结点来方便操作")
public class Leetcode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead=new ListNode(0,head);
        ListNode fast=newHead;
        ListNode preSlow=newHead;
        while (n >0) {
            fast=fast.next;
            n--;
        }
        while (fast != null && fast.next != null) {
            fast=fast.next;
            preSlow=preSlow.next;
        }
        preSlow.next=preSlow.next.next;
        return newHead.next;
    }
}
