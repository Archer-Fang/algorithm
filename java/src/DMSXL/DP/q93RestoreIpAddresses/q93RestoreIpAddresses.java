package DMSXL.DP.q93RestoreIpAddresses;


import java.util.LinkedList;
import java.util.List;

//Java：复原 IP 地址
public class q93RestoreIpAddresses{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.restoreIpAddresses("0000");
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> r=new LinkedList<>();
    List<String> p=new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        if(s.length()>12) return new LinkedList<>();
        backtrace(s,0,0);
        return r;
    }

    public void backtrace(String s, int start, int step) {
        if(step==4&&start==s.length()){
            String s1=join(p);
            r.add(s1.substring(0,s1.length()-1));
        }
        for (int i = start; i < s.length(); i++) {
            if(judge(s.substring(start,i+1))){
                p.add(s.substring(start,i+1));
                backtrace(s,i+1,step+1);
                p.remove(p.size()-1);
            }
            else continue;

        }
    }

    private String join(List<String> p) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String s : p) {
            stringBuffer.append(s+".");
        }
        return stringBuffer.toString();
    }

    public boolean judge(String s){
        if(s.length()>4) return false;
        int i = Integer.parseInt(s);
        if(i>255||i<0){
            return false;
        }
        if(s.length()>1&&s.charAt(0)=='0') return false;
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
