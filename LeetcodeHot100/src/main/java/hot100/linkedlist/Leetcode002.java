package hot100.linkedlist;

import annotations.Star;

@Star("注意可以不需要实际补充节点 可以模拟0节点；其次注意carry的计算；最后注意指针如何判断是否该迭代")
public class Leetcode002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode cur=newHead;
        int carry=0;
        while (l1 != null || l2 != null) {
            int x = (l1 == null ? 0 : l1.val);
            int y = (l2 == null ? 0 : l2.val);
            int sum = x + y + carry;
            carry = sum / 10;
            sum %= 10;
            cur.next=new ListNode(sum);
            cur=cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return  newHead.next;
    }
    public ListNode addTwoNumbers_(ListNode l1, ListNode l2) {
        boolean carry=false;
        ListNode h1=l1;
        ListNode pre1=l1;
        ListNode h2=l2;
        ListNode pre2=l2;

        while (h1 != null && h2 != null) {
            if (carry){
                h1.val += h2.val + 1;
                carry = false;
            }else {
                h1.val+=h2.val;
            }

            if (h1.val > 9) {
                h1.val%=10;
                carry=true;
            }
            pre1=h1;
            pre2=h2;
            h1=h1.next;
            h2=h2.next;
        }
        if (h2 == null) {
            if (carry && h1 == null) {
                pre1.next = new ListNode(1, null);
                return l1;
            } else if (carry && h1 != null) {
                while (h1 != null) {
                    if (carry) {
                        h1.val+=1;
                        carry=false;
                    }
                    if (h1.val > 9) {
                        h1.val%=10;
                        carry=true;
                    }
                    pre1=h1;
                    h1=h1.next;
                }
                if (carry) {
                    pre1.next = new ListNode(1, null);
                }
            }

        } else {
            pre1.next=h2;
            if (carry) {
                while (h2 != null) {
                    if (carry) {
                        h2.val += 1;
                        carry=false;
                    }
                    if (h2.val > 9) {
                        h2.val %= 10;
                        carry = true;
                    }
                    pre1=h2;
                    h2 = h2.next;
                }
                if (carry) {
                    pre1.next = new ListNode(1, null);
                }
            }

        }
        return l1;
    }
}
