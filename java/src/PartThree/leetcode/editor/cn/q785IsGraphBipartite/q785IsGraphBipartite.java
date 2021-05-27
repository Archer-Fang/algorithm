package PartThree.leetcode.editor.cn.q785IsGraphBipartite;
//Java：判断二分图

import java.util.LinkedList;
import java.util.Queue;

public class q785IsGraphBipartite{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isBipartite(int[][] graph) {
        // 定义 visited 数组，初始值为 0 表示未被访问，赋值为 1 或者 -1 表示两种不同的颜色。
        Queue<Integer> queue=new LinkedList<>();
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(visited[i]!=0) continue;
            visited[i]=1;
            queue.add(i);
            while (!queue.isEmpty()){
                int nearNode=queue.poll();
                for (Integer j:graph[nearNode]) {
                    if(visited[nearNode]==visited[j]) return false;
                    if(visited[j]==0) {
                        visited[j]=-visited[nearNode];
                        queue.add(j);
                    }
                }
            }


        }
        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
