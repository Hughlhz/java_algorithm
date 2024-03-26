package hot100.linkedlist;

public class Leetcode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode nextK=head;
        for (int i = 0; i < k; i++) {
            if (nextK == null) {
//                如果最后返回也要反转，那就返回reverse，否则直接head即可
//                return reverse(head,k);
                    return head;
            }
            nextK=nextK.next;

        }
        ListNode temp = reverse(head, k);
        head.next = reverseKGroup(nextK,k);
        return temp;

    }

    private ListNode reverse(ListNode head,int k) {
        ListNode newHead = new ListNode();
        ListNode temp;
        for (int i = 0; i < k; i++) {
            temp = newHead.next;
            newHead.next=head;
            head=head.next;
            newHead.next.next=temp;
            if (head == null) {
                return newHead.next;
            }
        }
        return newHead.next;
    }
}
