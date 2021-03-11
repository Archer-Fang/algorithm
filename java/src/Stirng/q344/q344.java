package Stirng.q344;

/**
 * @author Created by Fangzj
 * @data 2021/3/11 13:33
 **/
class Solution {
    public void reverseString(char[] s) {
        int n=s.length;
        for (int i=n-1;i>=n/2;i--){
            char tmp=s[n-i-1];
            s[n-i-1]=s[i];
            s[i]=tmp;
        }
//        System.out.println(s);
    }
}
public class q344 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.reverseString("hell".toCharArray());
    }

}
