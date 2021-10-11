package nowcoder.pdd.q3;

import java.util.Arrays;
import java.util.Scanner;

/**todo
 * @author Created by Fangzj
 * @data 2021/10/11 11:21
 **/
//5 2
//1 2 3 4 5
    //ans:6
//长度为1: [2], [4]
//长度为2: 无
//长度为3: [1,2,3], [3,4,5]
//长度为4: [1,2,3,4], [2,3,4,5]
//长度为5: 无
//共6个区间的和谐值之和可以被2整除。
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] NM = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        int N=NM[0],M=NM[1];
        int[] arr = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        long sum = 0;
        long ans = 0;
        int[] map = new int[N];
        map[0]=1;
        for (int i = 0; i < N; ++i){
            sum += arr[i];
            int index = (int) (sum % M);
            ans += map[index]++;
        }
        System.out.println(ans);

    }

    private static boolean sumAndJudge(int[] nums, int i, int j,int M) {
        long sum=0;
        for (int k = i; k <= j; k++) {
            sum+=nums[k];
        }
        return sum%M==0;
    }
}

