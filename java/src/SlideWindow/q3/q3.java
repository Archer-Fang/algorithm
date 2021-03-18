package SlideWindow.q3;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Created by Fangzj
 * @data 2021/3/15 19:56
 **/
class Solution {
//    public int lengthOfLongestSubstring(String s) {
//        int L=0,ans=0;
//        int R=0;
//        for(;R<s.length();R++){
//            while (s.substring(L,R).contains(s.substring(R,R+1))){
//                ans=Math.max(ans,R-L);
//                L++;
//            }
//        }
//        return ans>(R-L)?ans:(R-L);
//    }
    public int lengthOfLongestSubstring(String s) {
        int L=0,ans=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int R=0;R<s.length();R++){
            map.put(s.charAt(R),map.getOrDefault(s.charAt(R),0)+1);
            while (map.getOrDefault(s.charAt(R),0)>1){
                map.put(s.charAt(L),map.getOrDefault(s.charAt(L++),0)-1);
            }
            ans=Math.max(ans,R-L+1);
        }
        return ans;
    }

}
public class q3 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.lengthOfLongestSubstring(" "));
    }
}
