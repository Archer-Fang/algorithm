package PartOneReWrite.Heap.q857MinimumCostToHireKWorkers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//Java：雇佣 K 名工人的最低成本
public class q857MinimumCostToHireKWorkers{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.mincostToHireWorkers(new int[]{10,20,5},new int[]{70,50,30},2));;
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        //工作效率：quality/wage
        double[][] eff = new double[quality.length][3];
        for (int i = 0; i < quality.length; i++) {
            eff[i][0]=(double) quality[i]/(double)wage[i];
            eff[i][1]=wage[i];
            eff[i][2]=quality[i];
        }
        //工作效率:高->差
        Arrays.sort(eff, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return Double.compare(o2[0],o1[0]);
            }
        });
        //找完成质量最差的
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((o1, o2) -> Double.compare( o2[2],o1[2]));
        double ans=Double.MAX_VALUE;
        for (int i = 0; i < eff.length; i++) {
            maxHeap.add(eff[i]);
            if(maxHeap.size()>k) maxHeap.poll();
            if(maxHeap.size()==k){
                double effPerWage=eff[i][0];
                double tmp=0;
                for (double[] doubles : maxHeap) {
                    tmp+=doubles[2]/effPerWage;
                }
                ans=Math.min(ans,tmp);
            }
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
