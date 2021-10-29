package QiuZhao.writtenExamination.DB.q2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/10/24 10:05
 **/
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        in.nextLine();
        String s = in.nextLine();
        char[] chars = s.toCharArray();
        //find first lr
        int l=chars.length,r=chars.length;
        for (int i = 0; i < chars.length; i++) {
            if('L'==chars[i]&&l==chars.length){
                l=i;
            }
            if('R'==chars[i]&&r==chars.length){
                r=i;
            }
        }
        int[] ans = new int[s.length() + 1];
        Arrays.fill(ans,s.length()+1);
        int k=0;
        if(r<l){
            for (int i = 0; i < r; i++) {
                ans[k++]=i+1;
            }
        }
        int start=Math.min(l,r);

        //find last lr
        l=-1;
        r=-1;
        for (int i = chars.length-1; i >= 0; i--) {
            if('L'==chars[i]&&l==-1){
                l=i;
            }
            if('R'==chars[i]&&r==-1){
                r=i;
            }
        }
        if(r<l){
            for (int i = l+1; i < chars.length; i++) {
                ans[k++]=i+1;
            }
        }

        int end=Math.max(l,r);
        for (int i = start+1; i <= end; i++) {
            if(chars[i]=='R'){
                for (int j = start+1; j < i; j++) {
                    ans[k++]=j+1;
                }
                start=i;
            }else if(chars[i]=='L'){
                if((start+i)%2==0){
                    ans[k++]=(start+i)/2+1;
                }
                start=i;
            }
        }
        Arrays.sort(ans);
        String p="";
        for (int i = 0; i < ans.length; i++) {
            if(ans[i]==ans.length) break;
            p+=ans[i]+" ";
        }
        p= p.trim();
        if("".equals(p)){
            for (int i = 0; i < chars.length; i++) {
                p+=(i+1)+" ";
            }
        }
        p= p.trim();
        System.out.println(p);
        //14
        //.L.R...LR..L..

        //3 6 13 14

        //14
        //.R.L...RL..R..

        //1,3,5,6,7,10,11





    }
}
