package PartThree.leetcode.editor.cn.q399EvaluateDivision;

import java.util.HashMap;
import java.util.List;

//Java：除法求值
public class q399EvaluateDivision{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST

    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //Floyd
        HashMap<String, Integer> map = new HashMap<>();
        int c=0;
        for (List<String> equation : equations) {
            for (String s : equation) {
                if(!map.containsKey(s)){
                    map.put(s,c++);
                }

            }
        }
        int n=map.size();
        double[][] graph = new double[map.size()][map.size()];
        for (String s : map.keySet()) {
            graph[map.get(s)][map.get(s)]=1;
        }
        for (int i = 0; i < equations.size(); i++) {
            graph[map.get(equations.get(i).get(0))][map.get(equations.get(i).get(1))]= values[i];
            graph[map.get(equations.get(i).get(1))][map.get(equations.get(i).get(0))]= 1/values[i];
        }
        //i是中间值
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(graph[j][i]!=0&&graph[i][k]!=0){
                        graph[j][k]=graph[j][i]*graph[i][k];
                    }
                }
            }
        }
        double[] r=new double[queries.size()];
        c=0;
        for (List<String> query : queries) {
            if(!map.containsKey(query.get(0))||!map.containsKey(query.get(1))) r[c++]=-1;
            else r[c++]=graph[map.get(query.get(0))][map.get(query.get(1))]==0?-1:graph[map.get(query.get(0))][map.get(query.get(1))];
        }
        return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
