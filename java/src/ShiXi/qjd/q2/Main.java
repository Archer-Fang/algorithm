package ShiXi.qjd.q2;

/**
 * @author Created by Fangzj
 * @data 2021/4/24 19:51
 **/

import java.util.*;

class Solution {
    long sum=0;
    public void needNum(int n) {
        //对n-1个数进行排序
        Stack<Integer> stack=new Stack();
        int[] nums=new int[n-1];
        for (int i=1;i<nums.length+1;i++){
            nums[i-1]=i;
        }
        int[] visit=new int[n-1];
        for (int i=0;i<nums.length;i++){
            Arrays.fill(visit,0);
            stack.clear();
            stack.add(0);
            visit[i]=1;
            stack.add(nums[i]);
            dfs(nums,0,stack,visit,i);
        }
        System.out.println(sum%998244353);
        return;
    }
    public void dfs(int[] num,int step,Stack stack,int[] visit,int k){

        if((num[k] - (int)stack.peek())>2) return;

        else {

            for (int i=0;i<num.length;i++){
                if(visit[i]!=1){
                    visit[i]=1;
                    stack.add(num[i]);
                    if(stack.size()==visit.length+1){
                        sum++;
                        return;
                    }
                    dfs(num,step+1,stack,visit,i);
                    stack.pop();
                }

            }
        }



        return;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        int[] d1 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        solution.needNum(d1[0]);


    }
}
//1
//3 3
//3
//6
//9
//3
//[0, 1, 2, 3]
//[0, 2, 1, 3]