package DMSXL.DP.q726NumberOfAtoms;

import java.util.Stack;
import java.util.TreeMap;

//Java：原子的数量
public class q726NumberOfAtoms{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.countOfAtoms("Mg(OH)2");
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int i=0;
    public String countOfAtoms(String formula) {
        Stack<TreeMap<String, Integer>> stack = new Stack<TreeMap<String, Integer>>();
        stack.add(new TreeMap<>());
        char[] chars = formula.toCharArray();
        while (i<formula.length()){
            if(chars[i]=='('){
                i++;
                stack.add(new TreeMap<>());
            } else if(chars[i]==')'){
                i++;
                int num = parseNum( chars);
                TreeMap<String, Integer> pop = stack.pop();
                TreeMap<String, Integer> peek = stack.peek();
                for (String key : pop.keySet()) {
                    peek.put(key,pop.getOrDefault(key,0)*num+peek.getOrDefault(key,0));
                }
            }else {
                TreeMap<String, Integer> peek = stack.peek();
                String string = parseString(chars);
                int num = parseNum( chars);
                peek.put(string,peek.getOrDefault(string,0)+num);

            }
        }
        String ans="";
        TreeMap<String, Integer> peek = stack.peek();
        for (String key : peek.keySet()) {
            Integer tmp = peek.get(key);
            ans+=tmp==1?key:key+tmp;
        }
        return ans;

    }
    public String parseString(char[] chars){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(chars[i++]);
        while (i<chars.length&&Character.isLowerCase(chars[i])){
            stringBuffer.append(chars[i++]);
        }
        return stringBuffer.toString();
    }
    public int parseNum(char[] chars){
        if(i==chars.length||!Character.isDigit(chars[i])) return 1;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(chars[i++]);
        while (i<chars.length&&Character.isDigit(chars[i])){
            stringBuffer.append(chars[i++]);
        }
        return Integer.parseInt(stringBuffer.toString());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
