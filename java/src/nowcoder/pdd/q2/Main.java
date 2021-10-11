package nowcoder.pdd.q2;

import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/10/11 11:09
 **/
public class Main {
    public static void main(String[] args) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        Scanner in = new Scanner(System.in);
        String tmp = in.nextLine();
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i)-'a']++;
            count2[s2.charAt(i)-'a']++;
        }
        int ans=0;
        for (int i = 0; i < 26; i++) {
            if(count1[i]==count2[i]) continue;
            if(count1[i]<count2[i]){
                int d=count2[i]-count1[i];
                count2[i+1]+=d;
                count2[i]=count1[i];
                ans+=d;
            }
            if(count1[i]>count2[i]){
                int d=count1[i]-count2[i];
                for (int j = i+1; j < 26; j++) {
                    if(count2[j]>=d){
                        count2[j]-=d;
                        count2[i]+=d;
                        ans+=d*(j-i);
                        break;
                    }else {
                        count2[i]+=count2[j];
                        ans+=count2[j]*(j-i);
                        d-=count2[j];
                        count2[j]=0;
                    }
                }
            }
        }
        System.out.println(ans);

    }
}
