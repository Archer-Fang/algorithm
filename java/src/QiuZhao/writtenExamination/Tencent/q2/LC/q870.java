package QiuZhao.writtenExamination.Tencent.q2.LC;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Created by Fangzj
 * @data 2021/9/11 13:33
 **/
public class q870 {
    class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            int[] ans = new int[nums1.length];
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>((a, b) -> {
               return -(a[1] - b[1]);
            });
            for (int i = 0; i < nums2.length; i++) {
                priorityQueue.add(new int[]{i,nums2[i]});
            }
            Arrays.sort(nums1);
            int l=0,r=nums1.length-1;

            while (!priorityQueue.isEmpty()){
                int[] poll = priorityQueue.poll();
                if(nums1[r]>poll[1]){
                    ans[poll[0]]=nums1[r];
                    r--;
                }else {
                    ans[poll[0]]=nums1[l++];
                }

            }
            return ans;
        }
    }
}
