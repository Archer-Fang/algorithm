package Interview.qtenxunv2.q1;

/**
 * @author Created by Fangzj
 * @data 2021/4/18 20:07
 **/

 import java.util.Arrays;
 import java.util.LinkedList;
 import java.util.Scanner;

class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param S ListNode类 val表示权值，next指向下一个元素
     * @return ListNode类
     */
    public Boolean cmp(ListNode l1, ListNode l2, ListNode head,int len){
        while ((len--)>0){
            if(l1==null) l1=head;
            if(l2==null) l2=head;
            if(l1.val>l2.val) return true;
            l1=l1.next;
            l2=l2.next;
        }
        return false;
    }
    public int getLen(ListNode head){
        int l=0;
        ListNode cur=head;
        while (cur!=null){
            cur=cur.next;
            l++;
        }
        return l;
    }

    //对于数字都不相同的，使用快慢指针
    public ListNode solve (ListNode S) {
        int l=getLen(S);
        ListNode cur=S;
        ListNode pre=S;
        for (int i=1;i<l;i++){
            cur=cur.next;
            if(!cmp(pre,cur,S,l)){
                pre=cur;
            }

        }
        cur=pre.next;
        l--;
        while ((l--)>0){
            if(cur==null) cur=S;
            if(l==0) cur.next=null;
            cur=cur.next;
        }
        return pre;
    }
}
 public class Main {
     public static void main(String[] args) {
         Solution solution=new Solution();
         ListNode l1=new ListNode(2);
         ListNode l2=new ListNode(2);
         ListNode l3=new ListNode(5);
         ListNode l4=new ListNode(2);
         l1.next=l2;
         l2.next=l3;
         l3.next=l4;
         System.out.println(solution.solve(l1));
     }
 }
