package QiuZhao.writtenExamination.Tencent.q1;

/**
 * @author Created by Fangzj
 * @data 2021/9/5 19:51
 **/
//多个链表合并
public class Main {
    public static class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode solve(ListNode[] a) {
        // write code here
        return mergeKListNode(a);
    }
    public static ListNode mergeKListNode(ListNode[] a) {
        // write code here
        if(a.length==0) return null;
        if(a.length==1) return a[0];
        int mid=a.length/2;
        ListNode[] l = new ListNode[mid];
        ListNode[] r = new ListNode[a.length-mid];
        for (int i = 0; i < mid; i++) {
            l[i]=a[i];
        }
        for (int i = mid; i < a.length; i++) {
            r[i-mid]=a[i];
        }
        return mergeTwoListNode(mergeKListNode(l),mergeKListNode(r));
    }

    public static ListNode mergeTwoListNode(ListNode a, ListNode b) {
        ListNode ans=new ListNode(-1);
        if(a==null) return b;
        if(b==null) return a;
        ListNode cur1=a,cur2=b,cur=ans;
        while (cur1!=null&&cur2!=null){
            ListNode tmp1=cur1.next;
            cur1.next=cur.next;
            cur.next=cur1;
            cur1=tmp1;
            cur=cur.next;

            ListNode tmp2=cur2.next;
            cur2.next=cur.next;
            cur.next=cur2;
            cur2=tmp2;
            cur=cur.next;

        }
        if(cur1!=null){
            cur.next=cur1;
        }
        if(cur2!=null){
            cur.next=cur1;
        }
        return ans.next;
    }


}

