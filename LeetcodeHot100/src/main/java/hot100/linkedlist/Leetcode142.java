package hot100.linkedlist;

import annotations.Star;

@Star("计算入环的位置，需要简单计算 注意：1、相遇的位置一定是slow指针入环后的第一圈内 2、x=z+(k-1)(z+y)  就是入环位置mod环长=相遇位置到入环位置的距离")
public class Leetcode142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode index1=head;
        ListNode index2;
        while (fast != null && fast.next != null) {
            fast=fast.next.next;
            slow=slow.next;
            if (slow == fast) {
                index2=slow;
                while (index2 != index1) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return  null;
    }
}
