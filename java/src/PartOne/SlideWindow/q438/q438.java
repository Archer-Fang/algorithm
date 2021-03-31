package PartOne.SlideWindow.q438;

import java.util.*;

/**
 * @author Created by Fangzj
 * @data 2021/3/15 20:34
 **/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new LinkedList<>();
        int[] S=new int[26];
        int[] P=new int[26];
        for(char item:p.toCharArray()) P[item-'a']+=1;
        int L=0;
        for (int R=0;R<s.length();R++){
            S[s.charAt(R)-'a']+=1;
            while (S[s.charAt(R)-'a']>P[s.charAt(R)-'a']){
                S[s.charAt(L)-'a']-=1;
                L++;
            }
            if(R-L+1==p.length()) ans.add(L);
        }
        return ans;
    }
}

public class q438 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.findAnagrams("abab", "ab"));
    }
}
