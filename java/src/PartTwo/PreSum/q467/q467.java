package PartTwo.PreSum.q467;

import java.util.Arrays;

/**
 * @author Created by Fangzj
 * @data 2021/3/31 19:14
 **/
class Solution {
    public int findSubstringInWraproundString(String p) {
        //find alph ends with max num
        //abcd
        //alph[0]=1;alph[1]=3=1+2;alph[2]=6=1+2+3;alph[3]=10==1+2+3+4;
        if(p.length()==1) return 1;
        if(p.length()==0) return 0;
        int[] alphs=new int[26];
        int c=1;
        int ans=-1;
        alphs[p.charAt(0)-'a']=1;
        for (int i=1;i<p.length();i++){
            if(p.charAt(i)-p.charAt(i-1)==1||p.charAt(i)-p.charAt(i-1)=='a'-'z'){
                c++;
                alphs[p.charAt(i)-'a']=Math.max(alphs[p.charAt(i)-'a'],c);
            } else {
                c=1;
                alphs[p.charAt(i)-'a']=Math.max(alphs[p.charAt(i)-'a'],c);
            }

        }
        return Arrays.stream(alphs).sum();
    }
}
public class q467 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.findSubstringInWraproundString("a"));
        System.out.println(solution.findSubstringInWraproundString("cac"));
        System.out.println(solution.findSubstringInWraproundString("zab"));
        System.out.println(solution.findSubstringInWraproundString("zaba"));
    }
}
