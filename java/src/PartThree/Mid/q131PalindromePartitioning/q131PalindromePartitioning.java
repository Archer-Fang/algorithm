package PartThree.Mid.q131PalindromePartitioning;

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
    public List<List<String>> partition(String s) {
        List<String> list = new LinkedList<>();
        List<List<String>> lists = new LinkedList<>();
        dfs(s.toCharArray(),list,lists,0);
        return lists;
    }

    private void dfs(char[] s, List<String> list, List<List<String>> lists,int index) {
        if(index==s.length){
            lists.add(new LinkedList<>(list));
        }
        for (int i = index; i < s.length; i++) {
            if(isHuiWen(s,index,i)){
                list.add(new String(s, index, i + 1 - index));
                dfs(s,list,lists,i+1);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isHuiWen(char[] s,int l,int r) {
        while (l<=r){
            if(s[l]!=s[r]) return false;
            l++;
            r--;
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
