package QiuZhao.writtenExamination.XC.q3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/10/21 18:56
 **/
//5
//3 1 2 1 3

//6

//6次闪电攻击的目标分别为：
//
//{1}
//
//{1}
//
//{1,2,3,4,5}
//
//{3}
//
//{5}
//
//{5}
    //72%
public class Main2 {
    static int ans=0;
    public static void main(String[] args) {

        //首先，这个次数最多能有几次。 min+sum-min*num.length
        //最少，则需要数字大的尽可能连在一起。如果不连着一起必定会有惩罚。 min+ds.
        //3 1 2 1 3
        //[0,2,1,1,2.0]
        Scanner in = new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();

        cal(nums,n);
        System.out.println(ans);




    }

    private static void cal(int[] arr, int n) {
        if(n==0) return ;
        int minn= Arrays.stream(arr).min().getAsInt();
        ans+=minn;
        int ind=0;
        for (int i = 0; i < n; i++) {
            arr[i]=arr[i]-minn;
            if(arr[i]==0){
                if(ind==i){
                    ind+=1;
                }
                else {
                    cal( Arrays.copyOfRange(arr,ind,i),i-ind);
                    ind=i+1;
                }
            }
        }
        if(ind<n){
            cal( Arrays.copyOfRange(arr,ind,n),n-ind);
        }
    }
}
