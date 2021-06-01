package PartThree.Mid.q686RepeatedStringMatch;
//Java：重复叠加字符串匹配

public class q686RepeatedStringMatch{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.repeatedStringMatch("abcd","cdabcdab"));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int repeatedStringMatch(String a, String b) {
        int c=0;
        String accA="";
        while (accA.length()<=(2*a.length()+b.length())){
            accA+=a;
            c++;
            if(accA.indexOf(b)!=-1) return c;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
