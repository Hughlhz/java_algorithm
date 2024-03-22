package hot100.linkedlist;

public class Leetcode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode A=headA;
        ListNode B=headB;
        while (true) {
            if (A == B) {
                return A;
            }

            A=A.next;
            B = B.next;
            if (A == null && B == null) {
                return null;
            }
            if (A == null) {
                A=headB;
            }
            if (B == null) {
                B = headA;
            }

        }

    }
}
