package nowcoder.pdd.q1;

import java.util.Scanner;

/**todo
 * @author Created by Fangzj
 * @data 2021/10/10 9:52
 **/
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N=Integer.parseInt(in.nextLine());
        if(N<10){
            System.out.println(N);
            return;
        }
        int ans=0;
        int digit=0;
        for (int i = 9; i >=1 ; i--) {
            if(N>=i){
                ans= (int) (Math.pow(10,digit)*i+ans);
                N-=i;
                digit++;
            }
        }
        if(N==0) System.out.println(ans);
        else System.out.println(-1);





    }
}
