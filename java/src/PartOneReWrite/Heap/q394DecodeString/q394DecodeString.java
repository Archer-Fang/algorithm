package PartOneReWrite.Heap.q394DecodeString;

import java.util.Stack;

//Java：字符串解码
public class q394DecodeString{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.decodeString("3[a2[c]]");
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String decodeString(String s) {
        Stack<Item> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int i=0;
        int tmpNum=0;
        StringBuffer stringBuffer=new StringBuffer();
        while (i<chars.length){

            if(Character.isDigit(chars[i])){
                tmpNum=tmpNum*10+Integer.parseInt(String.valueOf(chars[i++]));
            } else if (chars[i]=='['){
                i++;
                stack.add(new Item(tmpNum,stringBuffer.toString()));
                tmpNum=0;
                stringBuffer=new StringBuffer();
            } else if (chars[i]==']'){
                i++;
                Item pop = stack.pop();
                String s1 = stringBuffer.toString();
                stringBuffer=new StringBuffer();
                for (int j = 0; j < pop.num; j++) {
                    stringBuffer.append(s1);
                }
                stringBuffer= new StringBuffer(pop.s+stringBuffer.toString());
            }
            else {
                stringBuffer.append(chars[i++]);
            }
        }

        return stringBuffer.toString();
    }
    class Item{
        int num;
        String s;

        public Item(int num, String s) {
            this.num = num;
            this.s = s;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
