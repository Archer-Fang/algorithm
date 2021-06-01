package PartThree.Mid.q754ReachANumber;
//Java：到达终点数字

public class q754ReachANumber{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.reachNumber(2));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int reachNumber(int target) {
        //def 1+2+...+step=s, s>=target;
        //p+n=s
        //p-n=target
        //2*n=(s-target)=((step+1)*step/2-target)>=0
        target=Math.abs(target);
        int step=0;
        int twoN=((step+1)*step/2-target);
        while (true){
            if(twoN>=0&&twoN%2==0){
                break;
            }
            step++;
            twoN=((step+1)*step/2-target);
        }
        return step;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
