package QiuZhao.writtenExamination.Tencent.q3;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Created by Fangzj
 * @data 2021/9/26 21:10
 **/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] chars = s.toCharArray();
        Stack<Long> numStack = new Stack<>();
        Stack<String> opStack = new Stack<>();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if(Character.isDigit(chars[i])){
                stringBuffer.append(chars[i]);
            }else{
                numStack.add(Long.valueOf(stringBuffer.toString()));
                stringBuffer=new StringBuffer();
                while (!opStack.isEmpty()&&(opStack.peek().equals("@")||opStack.peek().equals("*"))){
                    String pop = opStack.pop();
                    if(pop.equals("@")){
                        Long a = numStack.pop();
                        Long b = numStack.pop();
                        numStack.add((a|(a+b)));
                    }else if(pop.equals("x")){
                        Long a = numStack.pop();
                        Long b = numStack.pop();
                        numStack.add(a*b);
                    }
                }
                opStack.add(String.valueOf(chars[i]));
            }
        }
        numStack.add(Long.valueOf(stringBuffer.toString()));
        while (!opStack.isEmpty()){
            String pop = opStack.pop();
            if(pop.equals("+")){
                numStack.add(numStack.pop()+numStack.pop());
            }else if(pop.equals("@")){
                Long a = numStack.pop();
                Long b = numStack.pop();
                numStack.add((a|(a+b)));
            }else if(pop.equals("x")){
                Long a = numStack.pop();
                Long b = numStack.pop();
                numStack.add(a*b);
            }

        }
        System.out.println(numStack.peek());


    }
}
