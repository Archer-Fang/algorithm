package PartOne.Stirng.q28;

/**
 * @author Created by Fangzj
 * @data 2021/3/11 13:21
 **/
class Solution {
    public int strStr(String haystack, String needle) {
        return  haystack.indexOf(needle);
    }
}
public class q28 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.strStr("hello","ll"));
    }
}

