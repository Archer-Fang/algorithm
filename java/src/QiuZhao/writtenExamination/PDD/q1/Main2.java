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
//作者：The_ban
//链接：https://www.nowcoder.com/discuss/770247?type=all&order=time&pos=&page=1&ncTraceId=&channel=-1&source_id=search_all_nctrack
//来源：牛客网
//
public class Main2 {
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
                                if((j-1>=0&&chars[k][j-1]=='*')||(j+1<w&&chars[k][j+1]=='*')||chars[k][j]!='*'){
                                    break;
                                }else {
                                    chars[i][j]='.';
                                }
                            }
                            //下
                            for (int k = i+1; k <h; k++) {
                                if((j-1>=0&&chars[k][j-1]=='*')||(j+1<w&&chars[k][j+1]=='*')||chars[k][j]!='*'){
                                    break;
                                }else {
                                    chars[i][j]='.';
                                }
                            }
                            //左
                            for (int k = j-1; k >= 0; k--) {
                                if((i-1>=0&&chars[i-1][k]=='*')||(i+1<h&&chars[i+1][k]=='*')||chars[i][k]!='*'){
                                    break;
                                }else {
                                    chars[i][j]='.';
                                }
                            }
                            //右
                            for (int k = j+1; k <w; k++) {
                                if((i-1>=0&&chars[i-1][k]=='*')||(i+1<h&&chars[i+1][k]=='*')||chars[i][k]!='*'){
                                    break;
                                }else {
                                    chars[i][j]='.';
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
                            ans.append("YES ");
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
            if((j-1>=0&&chars[k][j-1]=='*')||(j+1<w&&chars[k][j+1]=='*')||chars[k][j]!='*'){
                break;
            }else {
                ds[0]++;
            }
        }
        //下
        for (int k = i+1; k <h; k++) {
            if((j-1>=0&&chars[k][j-1]=='*')||(j+1<w&&chars[k][j+1]=='*')||chars[k][j]!='*'){
                break;
            }else {
                ds[1]++;
            }
        }
        //左
        for (int k = j-1; k >= 0; k--) {
            if((i-1>=0&&chars[i-1][k]=='*')||(i+1<h&&chars[i+1][k]=='*')||chars[i][k]!='*'){
                break;
            }else {
                ds[2]++;
            }
        }
        //右
        for (int k = j+1; k <w; k++) {
            if((i-1>=0&&chars[i-1][k]=='*')||(i+1<h&&chars[i+1][k]=='*')||chars[i][k]!='*'){
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
