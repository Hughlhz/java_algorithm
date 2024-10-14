package hot100.Array;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class ListNode{
    int val;
    ListNode next;
    public ListNode() {
    }
    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class Leetcode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }
        ListNode newHead = new ListNode();
        ListNode cur=newHead;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.remove();
            cur.next = node;
            cur=cur.next;
            if (node.next != null) {
                minHeap.add(node.next);
            }

        }
        return newHead.next;
    }
}
