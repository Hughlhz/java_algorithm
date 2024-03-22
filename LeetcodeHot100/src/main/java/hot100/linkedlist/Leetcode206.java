package hot100.linkedlist;

import java.util.List;

public class Leetcode206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode();
        ListNode temp = new ListNode();
        newHead.next=head;
        head=head.next;
        newHead.next.next=null;
        while (head != null) {
            temp=head.next;
            head.next=newHead.next;
            newHead.next=head;
            head = temp;
        }
        return newHead.next;
    }
    public ListNode reverseList_(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return node;
    }

}
