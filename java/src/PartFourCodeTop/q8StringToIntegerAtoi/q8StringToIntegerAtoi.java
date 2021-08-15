package PartFourCodeTop.q8StringToIntegerAtoi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Java：字符串转换整数 (atoi)
public class q8StringToIntegerAtoi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.myAtoi("    +1146905820n1"));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        Pattern compile = Pattern.compile("^([-+])?(\\d){1,201}");
        Pattern compile2 = Pattern.compile("^([-+])?(0){0,201}");
        Matcher matcher = compile.matcher(s);
        Matcher matcher2 = compile2.matcher(s);
        long i=0;


        if(matcher.find()) {
            String group = matcher.group(0);
            int inValidLen=0;
            if(matcher2.find()){
                inValidLen = matcher2.group(0).length();
            }
            String substring = group.substring(inValidLen, group.length());
            if(substring.length()==0) return 0;
            if (group.contains("-")) {
                if (substring.length() > 10) {
                    i = -2147483648L;
                } else {
                    i = Long.parseLong(substring);
                    if (i <= 2147483648L) {
                        i = -i;
                    } else {
                        i = -2147483648L;
                    }
                }
            } else {
                if (substring.length() > 10) {
                    i = 2147483647L;
                } else {
                    i = Long.parseLong(substring);
                    if (i <= 2147483647L) {
                        i = i;
                    } else{
                        i = 2147483647L;
                    }
                }
            }
        }
        return (int) i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
