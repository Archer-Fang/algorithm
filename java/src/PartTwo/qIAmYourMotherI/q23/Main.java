package PartTwo.qIAmYourMotherI.q23;

/**
 * @author Created by Fangzj
 * @data 2021/4/3 13:56
 **/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        if(lists.length==1) return lists[0];
        int mid=lists.length/2;
        ListNode[] l1=new ListNode[mid];
        ListNode[] l2=new ListNode[lists.length-mid];
        for (int i=0;i<mid;i++){
            l1[i]=lists[i];
        }
        for (int i=mid;i<lists.length;i++){
            l2[i-mid]=lists[i];
        }

        return mergeTwoLists(mergeKLists(l1),mergeKLists(l2));
    }
    public ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1==null&&l2==null) return null;
        if(l1.val<=l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }
        else {
            l2.next=mergeTwoLists(l2.next,l1);
            return l2;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        ListNode l11=new ListNode(1);
        ListNode l12=new ListNode(4);
        ListNode l13=new ListNode(5);
        ListNode l21=new ListNode(1);
        ListNode l22=new ListNode(3);
        ListNode l23=new ListNode(4);
        ListNode l31=new ListNode(2);
        ListNode l32=new ListNode(6);
        l11.next=l12;
        l12.next=l13;
        l21.next=l22;
        l22.next=l23;
        l31.next=l32;
        ListNode[] lists={l11,l21,l31};

        System.out.println(solution.mergeKLists(lists));
    }

}