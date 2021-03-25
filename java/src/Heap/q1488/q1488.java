package Heap.q1488;

import java.util.*;

/**
 * @author Created by Fangzj
 * @data 2021/3/24 21:08
 **/
class Solution {
    public int[] avoidFlood(int[] rains) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        HashMap<Integer,Integer> map=new HashMap();
        int[] ans=new int[rains.length];
        for (int i=0;i<rains.length;i++){
            if(rains[i]!=0){
                if(map.getOrDefault(rains[i],-1)>-1){
                    //开始实现
                    Iterator it=minHeap.iterator();
                    int r=-1;
                    while(it.hasNext()){
                        int tmp= (int) it.next();
                        if(tmp>map.get(rains[i])){
                            r=tmp;
                            break;
                        }
                    }
                    if(r==-1){
                        return new int[]{};
                    }else {
                        minHeap.remove(r);
                        ans[r]=rains[i];
                    }

                }
                ans[i]=-1;
                map.put(rains[i],i);
            }
            else {
                minHeap.add(i);
            }
        }
        for(int i=0;i<ans.length;i++){
            if(ans[i]==0) ans[i]++;
        }
        return ans;
    }


}

public class q1488 {
    public static void main(String[] args) {
        Solution solution=new Solution();
//        System.out.println(solution.avoidFlood(new int[]{1,2,0,2,3,0,1}));
//        System.out.println(solution.avoidFlood(new int[]{69,0,0,0,69}));
//        System.out.println(solution.avoidFlood(new int[]{1,0,2,0,2,1}));
        System.out.println(solution.avoidFlood(new int[]{1,0,2,0,2,1}));
    }
}
