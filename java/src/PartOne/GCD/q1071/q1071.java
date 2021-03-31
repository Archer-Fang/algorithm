package PartOne.GCD.q1071;

/**
 * @author Created by Fangzj
 * @data 2021/3/19 15:49
 **/
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)) return "";
        return str1.substring(0,gcb(str1.length(),str2.length()));
    }
    public int gcb(int a,int b){
        return b==0?a:gcb(b,a%b);
    }
}
public class q1071 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.gcdOfStrings("ABCABC","ABC"));
        System.out.println(solution.gcdOfStrings("ABABAB","ABAB"));
        System.out.println(solution.gcdOfStrings("LEET","CODE"));
    }
}
