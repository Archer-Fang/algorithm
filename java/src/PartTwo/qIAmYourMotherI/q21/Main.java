package PartTwo.qIAmYourMotherI.q21;

/**
 * @author Created by Fangzj
 * @data 2021/4/3 13:33
 **/
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur1=l1;
        ListNode cur2=l2;
        ListNode l3=new ListNode(0);
        ListNode cur3=l3;
        while (cur1!=null&&cur2!=null){
            if(cur1.val<=cur2.val){
                cur3.next=cur1;
                cur1=cur1.next;
                cur3=cur3.next;
            }else {
                cur3.next=cur2;
                cur2=cur2.next;
                cur3=cur3.next;
            }
        }
        if(cur1!=null){
            cur3.next=cur1;
        }else {
            cur3.next=cur2;
        }
        return l3.next;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        ListNode l11=new ListNode(1);
        ListNode l12=new ListNode(2);
        ListNode l13=new ListNode(4);
        ListNode l21=new ListNode(1);
        ListNode l22=new ListNode(3);
        ListNode l23=new ListNode(4);
        l11.next=l12;
        l12.next=l13;
        l21.next=l22;
        l22.next=l23;

        System.out.println(solution.mergeTwoLists(l11,l21));
    }

}
