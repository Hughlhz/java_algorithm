package hot100.linkedlist;

import annotations.Star;

@Star("归并排序！！！普通的选择排序和插入排序会超时")
public class Leetcode148 {
    public ListNode sortList(ListNode head) {
        return sort(head);
    }

    public static void main(String[] args) {
        ListNode n4 = new ListNode(3);
        ListNode n3 = new ListNode(1, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(4, n2);
//        printList(n1);
        Leetcode148 leetcode148 = new Leetcode148();
        ListNode sort = leetcode148.sort(n1);
        printList(sort);
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public  ListNode sort(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode fast=head,slow=head;
        fast=head.next;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode mid=slow;
//        System.out.println(slow.val);
        ListNode head2=mid.next;
        mid.next=null;
        ListNode list1=sort(head);
        ListNode list2=sort(head2);
        return merge(list1,list2);
    }
    public  ListNode merge(ListNode head1, ListNode head2){
        ListNode p1=head1;
        ListNode p2=head2;
        ListNode newHead=new ListNode(-1);
        ListNode cur=newHead;
        while(p1!=null&&p2!=null){
            if(p1.val<p2.val){
                cur.next=p1;
                cur=cur.next;
                p1=p1.next;
            }
            else{
                cur.next=p2;
                cur=cur.next;
                p2=p2.next;
            }
        }
        cur.next=null;
        if(p1!=null){
            cur.next=p1;
        }
        if(p2!=null){
            cur.next=p2;
        }
        return newHead.next;
    }







    public ListNode sortListInsert(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        ListNode oldHead = new ListNode(0, head);
        int max;
        ListNode pre=oldHead;
        ListNode maxNodePre;
        ListNode temp;
        while (oldHead.next != null) {
            maxNodePre=oldHead;
            max=maxNodePre.next.val;
            pre=oldHead;

            while (pre.next != null) {
                if (max < pre.next.val) {
                    max=pre.next.val;
                    maxNodePre=pre;
                }
                pre=pre.next;
            }
            //头插

            temp=maxNodePre.next;
            maxNodePre.next=temp.next;
            temp.next=newHead.next;
            newHead.next=temp;


        }
        return newHead.next;

    }
}
