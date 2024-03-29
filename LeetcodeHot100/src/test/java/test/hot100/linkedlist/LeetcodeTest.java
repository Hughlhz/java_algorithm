package test.hot100.linkedlist;

import hot100.doublepointer.Leetcode15;
import hot100.doublepointer.Leetcode42;
import hot100.linkedlist.Leetcode148;
import hot100.linkedlist.Leetcode25;
import hot100.linkedlist.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LeetcodeTest {
    @Test
    public void leetcode25Test() {
        Leetcode25 leetcode25 = new Leetcode25();
        ListNode n5=new ListNode(5);
        ListNode n4=new ListNode(4,n5);
        ListNode n3=new ListNode(3,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);

        leetcode25.reverseKGroup(n1,2);

    }
    @Test
    public void leetcode148Test() {
        Leetcode148 leetcode148 = new Leetcode148();
        ListNode n5=new ListNode(5);
        ListNode n4=new ListNode(4,n5);
        ListNode n3=new ListNode(3,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);

        leetcode148.sortList(n1);

        return;
    }

}
