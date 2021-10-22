package QiuZhao.writtenExamination.XC.q1;

import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/10/21 18:56
 **/
public class Main {
    public static void main(String[] args) {
        //考虑大写以后，后面的操作。
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] chars = s.toCharArray();
        int ans=0;
        for (int i = 0; i < chars.length-2; i++) {
            if(chars[i]==chars[i+1]){
                ans++;
                //如果三个字符串相等，则变中间的。
                //如果两个字符串相等，变前面的。
                if(chars[i]==chars[i+2]){
                    if(Character.isLowerCase(chars[i])){
                        chars[i+1]=Character.toUpperCase(chars[i+1]);
                    }else {
                        chars[i+1]=Character.toLowerCase(chars[i+1]);
                    }
                }else {
                    //如果不等，变当前的，什么都不做。
                    if(Character.isLowerCase(chars[i])){
                        chars[i]=Character.toUpperCase(chars[i]);
                    }else {
                        chars[i]=Character.toLowerCase(chars[i]);
                    }
                }


            }
        }
        //如果最后两个字符相等，变最后一个。
        if(chars[chars.length-1]==chars[chars.length-2]) {
            ans++;
            if(Character.isLowerCase(chars[chars.length-1])){
                chars[chars.length-1]=Character.toUpperCase(chars[chars.length-1]);
            }else {
                chars[chars.length-1]=Character.toLowerCase(chars[chars.length-1]);
            }
        }
        System.out.println(ans);

    }
}
