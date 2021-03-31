package Interview.qali.q1318;

/**
 * @author Created by Fangzj
 * @data 2021/3/29 10:49
 **/
class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int bitA = a >> i & 1;
            int bitB = b >> i & 1;
            int bitC = c >> i & 1;
            if (bitC == 0) {
                ans += bitA + bitB;
            } else {
                if (bitA == 0 && bitA == bitB) {
                    ans += 1;
                } else if (bitA == 0 && bitA != bitB) {
                    ans += 0;
                }

            }

        }
        return ans;
    }
}
public class q1318 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.minFlips(2,6,5));
    }
}
