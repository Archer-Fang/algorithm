package PartThree.Hot100.q406QueueReconstructionByHeight;

import java.util.PriorityQueue;

//Java：根据身高重建队列
public class q406QueueReconstructionByHeight{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b)->{
            if(a[0]!=b[0]){
                return b[0]-a[0];
            }else {
                return a[1]-b[1];
            }
        });
        for (int i = 0; i < people.length; i++) {
            int[] person = people[i];
            minHeap.add(person);
        }
        int[][] r = new int[people.length][people[0].length];
        int c=0;
        while (!minHeap.isEmpty()){
            int[] p=minHeap.poll();
            if(p[1]>=c){r[c++]=p;}
            else {

                for (int i = c; i > p[1] ; i--) {
                    r[i]=r[i-1];
                }
                r[p[1]]=p;
                c++;
            }
        }
        return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
