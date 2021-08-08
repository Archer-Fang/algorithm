package PartFourCodeTop.q3LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;

/**
 * @author Created by Fangzj
 * @data 2021/8/8 15:38
 **/
public class q3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        int tmp=lengthOfLongestSubstring("abcabcbb");
        System.out.println(1);
    }
    public static int lengthOfLongestSubstring(String s) {
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
