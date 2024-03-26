package hot100.linkedlist;

import annotations.Star;

import java.nio.channels.SelectionKey;
@Star("递归方法")
public class Leetcode21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.next == null) {
            list1.next=list2;
            return list1;
        }
        if (list2.next == null) {
            list2.next=list1;
            return list2;
        }
        if (list1.val <= list2.val) {

            list1.next=mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }


    }

}
