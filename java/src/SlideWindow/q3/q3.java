package SlideWindow.q3;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Created by Fangzj
 * @data 2021/3/15 19:56
 **/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int L=0,ans=0;
        int R=0;
        for(;R<s.length();R++){
            while (s.substring(L,R).contains(s.substring(R,R+1))){
                ans=Math.max(ans,R-L);
                L++;
            }
        }
        return ans>(R-L)?ans:(R-L);
    }

}
public class q3 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.lengthOfLongestSubstring(" "));
    }
}
