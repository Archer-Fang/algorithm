package DMSXL.DP.q131PalindromePartitioning;

import java.util.LinkedList;
import java.util.List;

//Java：分割回文串
public class q131PalindromePartitioning{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> r=new LinkedList<>();
    List<String> p=new LinkedList<>();
    String g="";
    public List<List<String>> partition(String s) {
        char[] chars = s.toCharArray();
        g=s;
        backtrace(chars,0);
        return r;
    }

    private void backtrace(char[] chars, int start) {
        if(start==chars.length){
            r.add(new LinkedList<>(p));
            return;
        }
        for (int i = start; i < chars.length; i++) {
            if(isHW(chars,start,i)){
                p.add(g.substring(start,i+1));
            }else{
                continue;
            }
            backtrace(chars,i+1);
            p.remove(p.size()-1);
        }
    }

    public boolean isHW(char[] s,int l,int r){
        while (l<r){
            if(s[l]==s[r]){
                l++;
                r--;
            }else {
                break;
            }
        }
        return l>=r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
