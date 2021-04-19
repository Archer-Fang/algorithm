package PartTwo.FrequentMedium.q210;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Created by Fangzj
 * @data 2021/4/17 15:13
 **/
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses<0) return new int[]{};
        HashSet<Integer>[] adj=new HashSet[numCourses];
        for (int i=0;i<numCourses;i++){
            adj[i]=new HashSet<>();
        }
        int[] inDgree=new int[numCourses];
        for (int i=0;i<prerequisites.length;i++){
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
            inDgree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for (int i=0;i<numCourses;i++){
            if(inDgree[i]==0) queue.add(i);
        }
        int[] r=new int[numCourses];
        int k=0;
        while (!queue.isEmpty()){
            int s=queue.poll();
            r[k++]=s;

            for (Integer tmp:adj[s]){
                if(--inDgree[tmp]==0) queue.add(tmp);
            }
        }
        if(k!=numCourses) return new int[]{};
        return r;

    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.findOrder(2, new int[][]{{1,0}} ));
    }
}
