package hot100.linkedlist;

import annotations.Star;

@Star("判断是否有环，只需要判断快慢指针是否相遇，有环一定会相遇")
public class Leetcode141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while (fast != null && fast.next != null) {
            fast=fast.next.next;
            slow=slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
