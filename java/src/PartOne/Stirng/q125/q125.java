package PartOne.Stirng.q125;

/**
 * @author Created by Fangzj
 * @data 2021/3/11 13:47
 **/
class Solution {
    public boolean isPalindrome(String s) {
        int right=s.length()-1;
        int left=0;
        while (left<=right){
            while (left<=right&&!Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left<=right&&!Character.isLetterOrDigit(s.charAt(right))) right--;
            if(left<=right&&Character.toLowerCase(s.charAt(right))!=Character.toLowerCase(s.charAt(left))) return false;
            else {left++;right--;}
        }
        return true;

    }
}
public class q125 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.isPalindrome(""));
    }
}
