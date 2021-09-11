package ShiXi.qali.q118;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Created by Fangzj
 * @data 2021/4/20 15:17
 **/
class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> l=new LinkedList<>();
        LinkedList ll=new LinkedList();
        ll.add(1);
        l.add(ll);
        if(numRows==1) return l;
        LinkedList ll2=new LinkedList();
        ll2.add(1);
        ll2.add(1);
        l.add(ll2);
        if(numRows==2) return l;

        for (int i=2;i<numRows;i++){
            LinkedList lLast= (LinkedList) l.get(i-1);
            LinkedList ll3=new LinkedList();
            ll3.add(1);
            int pre= (int) lLast.getFirst();
            for (int j=1;j<lLast.size();j++){
                int tmp= (int) lLast.get(j);
                ll3.add(pre+tmp);
                pre=tmp;
            }
            ll3.add(1);
            l.add(ll3);
        }
        return l;


    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.generate(5));
    }
}
