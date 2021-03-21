package BiteCompute;

import java.util.Arrays;

/**
 * @author Created by Fangzj
 * @data 2021/3/18 20:19
 **/
//??
class Solution {
    public int test(int[] nums) {
        int res=0;
        for (int i=0;i<32;i++){
            int c=0;
            int bit=1<<i;
            for (Integer num:nums){
                if((num&bit)!=0) c++;
            }
            if(c%3!=0) res|=bit;
        }
        return res;
    }
}
public class test {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.test(new int[]{3,3,3,1}));
    }
}
