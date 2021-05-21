package PartThree.leetcode.editor.cn.q394DecodeString;
//Java：字符串解码

import java.util.Stack;

public class q394DecodeString{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.decodeString("2[abc]3[cd]ef");
        solution.decodeString("3[a2[c]]");
        solution.decodeString("3[a]2[bc]");
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        Stack<Item> stack = new Stack<>();
        int i=0;
        int tmpNumber=0;
        StringBuffer stringBuffer = new StringBuffer();
        while (i<chars.length){
            if(chars[i]=='[') {
                stack.add(new Item(stringBuffer.toString(),tmpNumber));
                tmpNumber=0;
                stringBuffer=new StringBuffer();
            }
            if(Character.isDigit(chars[i])){
                tmpNumber= tmpNumber*10+Integer.parseInt(String.valueOf(chars[i]));
                while (i+1<chars.length&&Character.isDigit(chars[i+1])){
                    i++;
                    tmpNumber=tmpNumber*10+Integer.parseInt(String.valueOf(chars[i]));
                }

            }
            if(Character.isAlphabetic(chars[i])){
                stringBuffer.append(chars[i]);
                while (i+1<chars.length&&Character.isAlphabetic(chars[i+1])){
                    i++;
                    stringBuffer.append(chars[i]);
                }
            }

            if(chars[i]==']') {
                Item item=stack.pop();
                StringBuffer buffer = new StringBuffer();
                buffer.append(item.str);
                for (int j = 0; j < item.n; j++) {
                    buffer.append(stringBuffer);
                }
                stringBuffer=buffer;
            }
            i++;

        }



        return stringBuffer.toString();

    }
}
class Item{
    String str;
    int n;

    public Item(String str, int n) {
        this.str = str;
        this.n = n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
