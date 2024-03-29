package QiuZhao.writtenExamination.PDD.q1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/10/11 18:49
 **/
//1
//3 7
//.*...*.
//***.***
//.*...*.
//没想到ak了，大概说一下思路，第一题可以先预处理一下以每个点为中心向周围伸出的这四个分支的长度，统计出所有*的数量，然后遍历每个点，判断四个分支长度是不是相等以及四个分支加起来的长度是不是等于*的总量。第二题找到从左到右第一个'a'的位置，这个a之前的‘b’都是没法删掉的，同理从右到左找到‘b’的位置，后面那一串‘a’也是删不掉的，这两个位置中间若还有字符，最终都可以消为只剩一个‘b’。第三题主要就是判断一个数字时，填充问号使这个数字正好比前面大一点点。这种方式下能全部都处理，那就是可以的。第四题其实是个最长公共子序列的题，在这个环上切两刀，砍成两段，然后求两段的最长公共子序列长度。

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T=Integer.parseInt(in.nextLine());
        StringBuffer ans = new StringBuffer();
        while ((T--)>0){
            int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
            int h=nums[0],w=nums[1];
            char[][] chars = new char[h][w];
            for (int i = 0; i < h; i++) {
                String tmp = in.nextLine();
                for (int j = 0; j < tmp.length(); j++) {
                    chars[i][j]=tmp.charAt(j);
                }

            }
            int c=0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {

                    if(chars[i][j]=='*'){

                        if(judge(i,j,chars,w,h)){
                            chars[i][j]='.';
                            //上
                            for (int k = i-1; k >= 0; k--) {
                                if(chars[k][j]!='*'){
                                    break;
                                }else {
                                    chars[k][j]='.';
                                }
                            }
                            //下
                            for (int k = i+1; k <h; k++) {
                                if(chars[k][j]!='*'){
                                    break;
                                }else {
                                    chars[k][j]='.';
                                }
                            }
                            //左
                            for (int k = j-1; k >= 0; k--) {
                                if(chars[i][k]!='*'){
                                    break;
                                }else {
                                    chars[i][k]='.';
                                }
                            }
                            //右
                            for (int k = j+1; k <w; k++) {
                                if(chars[i][k]!='*'){
                                    break;
                                }else {
                                    chars[i][k]='.';
                                }
                            }
                            c++;
                        }


                    }
                }
            }
            if(c==0||c>1){
                ans.append("NO ");
            }else {
                boolean eg=false;
                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < w; j++) {
                        if(chars[i][j]=='*'&&!eg){
                            ans.append("NO ");
                            eg=true;
                        }
                    }

                }

                if(!eg) ans.append("YES ");
            }




        }
        String string = ans.toString();
        String[] p=string.substring(0,string.length()-1).split(" ");

        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i]);
        }





    }

    private static boolean judge(int i, int j, char[][] chars,int w,int h) {
        int[] ds = new int[4];
        //上
        for (int k = i-1; k >= 0; k--) {
            if(chars[k][j]!='*'){
                break;
            }else {
                ds[0]++;
            }
        }
        //下
        for (int k = i+1; k <h; k++) {
            if(chars[k][j]!='*'){
                break;
            }else {
                ds[1]++;
            }
        }
        //左
        for (int k = j-1; k >= 0; k--) {
            if(chars[i][k]!='*'){
                break;
            }else {
                ds[2]++;
            }
        }
        //右
        for (int k = j+1; k <w; k++) {
            if(chars[i][k]!='*'){
                break;
            }else {
                ds[3]++;
            }
        }

        if(ds[0]==ds[1]&&ds[1]==ds[2]&&ds[2]==ds[3]&&ds[0]!=0) {
            return true;
        }
        return false;
    }


}
//1
//5 5
//..*..
//..*..
//*****
//..*..
//..*..
