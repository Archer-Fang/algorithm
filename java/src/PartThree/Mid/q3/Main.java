package PartThree.Mid.q3;

import java.util.HashMap;

/**
 * @author Created by Fangzj
 * @data 2021/5/8 10:46
 **/
class Solution {

    public int lengthOfLongestSubstring(String s) {
        int start=0,ans=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                start=Math.max(start,map.get(s.charAt(i))+1);
            }
            ans=Math.max(ans,(i-start)+1);
            map.put(s.charAt(i),i);
        }
        return ans;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }
}
