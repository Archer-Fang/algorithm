package ShiXi.qbaidu.q2;

/**
 * @author Created by Fangzj
 * @data 2021/4/11 20:01
 **/

import java.util.Scanner;

class Solution {
    public int needNum(String in, String out,int k) {
        return (int) dfs(in,"",out,k);
    }

    public long dfs(String x, String y, String out, int k) {
        long count=0;

        if ((y + x).equals(out) && k == 0) {
            return ++count;
        }
        if(k<0) return count;
//        if(x.length()==1||y.length()==1) return count;
        String newS = y+x;
        int l=newS.length();
        for (int i = 0; i < newS.length() -1; i++) {
            long tmp=dfs(newS.substring(0, i + 1), newS.substring(i + 1, l), out, --k)%1000000007;
            count+=tmp;
        }
        return count%1000000007;
    }

}

public class Main {
    public static void main(String[] args) {
        //aaca
        //caaa
        //2
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        String s1=in.nextLine();
        String s2=in.nextLine();
        int k=in.nextInt();
//        System.out.println(solution.needNum("aaca","caaa",2));
        System.out.println(solution.needNum(s1,s2,k));

    }
}
