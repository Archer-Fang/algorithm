package Interview.qtenxunv3.q1;

/**
 * @author Created by Fangzj
 * @data 2021/4/29 15:50
 **/
import java.util.Scanner;
import java.util.Stack;
//s = "3[a]2[bc]"
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s=in.nextLine().split("\"")[1];
        Stack<String> numStack=new Stack<String>();
        Stack<String> charStack=new Stack<String>();
        StringBuilder sb=new StringBuilder();
        char[] chars=s.toCharArray();
        for(int i=0;i<chars.length;i++){
            char tmp=chars[i];
            if(tmp==']'){
                sb=new StringBuilder();
                while(!charStack.peek().equals("[")){
                    sb.append(charStack.pop());
                }
                charStack.pop();
                int num=Integer.parseInt(numStack.pop());
                String tmp3="";
                String tmp2=sb.reverse().toString();
                for(int k=0;k<num;k++){
                    tmp3+=tmp2;
                }
                if(!charStack.isEmpty()){
                    charStack.add(charStack.pop()+tmp3);
                }else {
                    charStack.add(tmp3);
                }


            }
            else if(tmp=='['){
                charStack.add("[");
            }
            else if(tmp=='0'||tmp=='1'||tmp=='2'||tmp=='3'||tmp=='4'||tmp=='5'||tmp=='6'||tmp=='7'||tmp=='8'||tmp=='9'){

                while((i+1<chars.length)&&(chars[i+1]=='0'||chars[i+1]=='1'||chars[i+1]=='2'||chars[i+1]=='3'||chars[i+1]=='4'||chars[i+1]=='5'||chars[i+1]=='6'||chars[i+1]=='7'||chars[i+1]=='8'||chars[i+1]=='9')){
                    tmp+=chars[i++];
                }
                numStack.add(String.valueOf(tmp));


            }else {
                charStack.add(String.valueOf(tmp));
            }
        }

        System.out.println(charStack.peek());

    }
}
