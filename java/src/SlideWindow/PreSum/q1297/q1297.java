package SlideWindow.PreSum.q1297;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Created by Fangzj
 * @data 2021/3/16 15:29
 **/
class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        //字母数量为maxlettes,maxSize必定涵盖minSize，因此只要考虑minSize就好了
        return maxFreq( s,  maxLetters, minSize);
    }
    private boolean isMatch(String str, int maxLetters) {
        HashSet<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
            if (set.size() > maxLetters) {
                return false;
            }
        }
        return true;
    }

    public int maxFreq(String s, int maxLetters,int minSize) {
        HashMap<String,Integer> map=new HashMap<>();
        for (int i=0;i<s.length()-minSize+1;i++){
            if(isMatch(s.substring(i,i+minSize),maxLetters)){
                map.put(s.substring(i,i+minSize),map.getOrDefault(s.substring(i,i+minSize),0)+1);
            }
        }
        return map.values().size()==0?0:map.values().stream().max((a, b) -> {
            if (a >= b) {
                return 1;
            } else return -1;
        }).get();
    }
}
public class q1297 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.maxFreq("abcde",2,3,3));
    }
}
