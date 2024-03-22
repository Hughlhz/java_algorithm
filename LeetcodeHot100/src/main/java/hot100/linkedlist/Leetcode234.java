package hot100.linkedlist;

import annotations.Star;

import java.util.LinkedList;
import java.util.List;

@Star("注意快慢指针找中点+原地反转链表是O（1）+ 必须会")
public class Leetcode234 {
    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        ListNode mid = findMid(head);
        ListNode l1=head,l2=mid.next;
        l2=reverseList(l2);
        return isSame(l1,l2);


    }

    private ListNode findMid(ListNode head) {
        ListNode fast=head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next=pre;
            pre=cur;
            cur=tmp;

        }
        return pre;

    }

    private boolean isSame(ListNode h1, ListNode h2) {
        ListNode p1 = h1;
        ListNode p2=h2;
        while (p2 != null) {
            if(p1.val!=p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return  true;
    }

}
