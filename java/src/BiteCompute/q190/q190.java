package BiteCompute.q190;

/**
 * @author Created by Fangzj
 * @data 2021/3/18 20:28
 **/
class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans=0;
        for (int i=0;i<32;i++){
            ans<<=1;
            ans+=n&1;
            n>>=1;
        }
        return ans;
    }
}
public class q190 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.reverseBits(0b00000010100101000001111010011100));
    }
}
