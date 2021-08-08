package PartThree.Hot100.q207CourseSchedule;

import java.util.*;

//Java：课程表
public class q207CourseSchedule{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.canFinish(2,new int[][]{{1,0}});
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //拓扑排序 没有依赖的指向有依赖的 统计入度数组以及领结矩阵
        int[] inDegree=new int[numCourses];
        HashMap<Integer,HashSet<Integer>> adj = new HashMap<>(numCourses);
        for (int i = 0; i < prerequisites.length; i++) {
            int[] prerequisite = prerequisites[i];
            inDegree[prerequisite[0]]+=1;
            HashSet<Integer> set = adj.getOrDefault(prerequisite[1], new HashSet<Integer>());
            set.add(prerequisite[0]);
            adj.put(prerequisite[1],set);
        }
        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            int i1 = inDegree[i];
            if(i1==0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            int independtNode=queue.poll();
            HashSet<Integer> hashSet = adj.get(independtNode);
            if(hashSet!=null){
                for (Integer tmp : hashSet) {
                    inDegree[tmp]-=1;
                    if(inDegree[tmp]==0) queue.add(tmp);
                }
            }

        }
        for (int i = 0; i < inDegree.length; i++) {
            int i1 = inDegree[i];
            if(i1!=0) return false;
        }
        return true;


    }
}

//leetcode submit region end(Prohibit modification and deletion)
