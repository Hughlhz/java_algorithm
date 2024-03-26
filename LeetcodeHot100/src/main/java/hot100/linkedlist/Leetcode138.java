package hot100.linkedlist;

import annotations.Star;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
@Star("注意使用map来完成旧节点和新节点的映射")
public class Leetcode138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node newHead = new Node(head.val);
        Node curOld = head.next;

        Map<Node, Node> map = new HashMap<>();
        map.put(head, newHead);
        Node preNew=newHead;
        Node temp;

        while (curOld != null) {
            temp=new Node(curOld.val);
            map.put(curOld, temp);
            preNew.next=temp;
            preNew=preNew.next;
            curOld=curOld.next;
        }
        preNew.next=null;

        Node curNew=newHead;
        curOld=head;
        while (curOld != null) {
            curNew.random = map.getOrDefault(curOld.random,null);
            curNew=curNew.next;
            curOld = curOld.next;
        }
        return newHead;


    }
}
