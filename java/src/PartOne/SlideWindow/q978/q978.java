package PartOne.SlideWindow.q978;

/**
 * @author Created by Fangzj
 * @data 2021/3/16 22:00
 **/
class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if(arr.length<2) return arr.length;
        if(arr.length==2) return arr[0]==arr[1]?1:2;
        int i=0;
        int ans=1;
        for (int j=2;j<arr.length;j++){
            if(arr[j]==arr[j-1]){
                i=j;
            }
            else if(((arr[j]-arr[j-1])^(arr[j-1]-arr[j-2]))>=0){
                i=j-1;
            }
            ans=Math.max(ans,j-i+1);
        }
        return ans;
    }
}
public class q978 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}));
        System.out.println(solution.maxTurbulenceSize(new int[]{100,100,100}));
        System.out.println(solution.maxTurbulenceSize(new int[]{9,9}));
        System.out.println(solution.maxTurbulenceSize(new int[]{4,5}));
    }
}
