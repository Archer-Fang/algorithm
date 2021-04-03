package PartTwo.qIAmYourMotherI.q1200;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Created by Fangzj
 * @data 2021/4/3 14:16
 **/
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min=Integer.MAX_VALUE;
        for (int i=0;i<arr.length-1;i++){
            min=Math.min(min,arr[i+1]-arr[i]);
        }
        List<List<Integer>> rs=new LinkedList<>();
        for (int i=0;i<arr.length-1;i++){
            if(arr[i+1]-arr[i]==min){
                LinkedList r=new LinkedList<>();
                r.add(arr[i]);
                r.add(arr[i+1]);
                rs.add(r);
            }
        }
        return rs;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.minimumAbsDifference(new int[]{4,2,1,3}));
    }
}
