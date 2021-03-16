package SlideWindow.q904;

import java.util.HashMap;

/**
 * @author Created by Fangzj
 * @data 2021/3/15 21:20
 **/
class Solution {
    public int totalFruit(int[] tree) {
        int L=0;
        int sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int R=0;R<tree.length;R++){
            map.put(tree[R],map.get(tree[R])==null?1:map.get(tree[R])+1);
            while (map.size()>2){
                map.put(tree[L],map.get(tree[L])-1);
                if(map.get(tree[L])==0) map.remove(tree[L]);
                L++;
            }
            sum=Math.max(R-L+1,sum);
        }
        return sum;
    }
}

public class q904 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }
}
