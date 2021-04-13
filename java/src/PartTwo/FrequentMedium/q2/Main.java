package PartTwo.FrequentMedium.q2;

import java.util.Arrays;

/**
 * @author Created by Fangzj
 * @data 2021/4/13 22:05
 **/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb=new StringBuilder();
        ListNode cur1=l1,cur2=l2,cur3=new ListNode(0),l3=cur3;
        int carry=0;
        while (cur1!=null||cur2!=null){
            int x=cur1==null?0:cur1.val;
            int y=cur2==null?0:cur2.val;
            int sum=x+y+carry;
            cur3.next=new ListNode(sum%10);
            carry=sum/10;
            cur3=cur3.next;
            if(cur1!=null) cur1=cur1.next;
            if(cur2!=null) cur2=cur2.next;
        }
        if(carry==1){
            cur3.next=new ListNode(1);
        }
        return l3.next;

    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        ListNode l1=new ListNode(9);
        ListNode l2=new ListNode(1);
        ListNode l3=new ListNode(9);
        ListNode l4=new ListNode(9);
        ListNode l5=new ListNode(9);
        ListNode l6=new ListNode(9);
        ListNode l7=new ListNode(9);
        ListNode l8=new ListNode(9);
        ListNode l9=new ListNode(9);
        ListNode l10=new ListNode(9);
        ListNode l11=new ListNode(9);
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        l6.next=l7;
        l7.next=l8;
        l8.next=l9;
        l9.next=l10;
        l10.next=l11;
        System.out.println(solution.addTwoNumbers(l1,l2));
    }
}
