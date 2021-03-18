package SlideWindow.q1234;

import java.util.Arrays;

/**
 * @author Created by Fangzj
 * @data 2021/3/17 20:55
 **/
class Solution {
    public int balancedString(String s) {
        int[] state=new int[4];
        //[1,1,1,1]
        //[2,1,1,0]
        //[3,1,0,0]
        for (char c:s.toCharArray()){
            if(c=='Q') state[0]++;
            if(c=='W') state[1]++;
            if(c=='E') state[2]++;
            if(c=='R') state[3]++;
        }

        int ans=s.length()+1;
        int k= s.length()/4;
        int i=0;
        char[] cs=s.toCharArray();
        if(state[0]==k&&state[1]==k&&state[2]==k&&state[3]==k) return 0;//已平衡，满足
        for (int j=0;j<cs.length;j++){
            //窗口外多了，进入窗口一个，窗口外少了，计数-1
            if(cs[j]=='Q') state[0]--;
            if(cs[j]=='W') state[1]--;
            if(cs[j]=='E') state[2]--;
            if(cs[j]=='R') state[3]--;
            while (i<cs.length&&state[0]<=k&&state[1]<=k&&state[2]<=k&&state[3]<=k){//窗口外满足条件，我要尽可能的让窗口小，让左端点出去，窗口外计数+1
                ans=Math.min(ans,j-i+1);
                if(cs[i]=='Q') state[0]++;
                if(cs[i]=='W') state[1]++;
                if(cs[i]=='E') state[2]++;
                if(cs[i]=='R') state[3]++;
                i++;
            }

        }
        return ans;
    }
}
//WWEQERQWQWWRWWERQWEQ
public class q1234 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.balancedString("QWER"));
//        System.out.println(solution.balancedString("QQWE"));
    }
}
