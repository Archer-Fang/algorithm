package QiuZhao.interview.pddV2.q1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/10/27 12:47
 **/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        int sum=0;
        int ans=0;
        String p="";
        LinkedList<Integer> l = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if(sum<=0) {sum=0;l= new LinkedList<>();}
            sum+=nums[i];
            l.add(nums[i]);
            if(sum>ans){
                ans=sum;
                p=getS(l);
            }

        }
        System.out.println(ans);
        System.out.println(p);
    }
    public static String getS(LinkedList<Integer> l){
        StringBuffer stringBuffer = new StringBuffer();
        for (Integer integer : l) {
            stringBuffer.append(integer+" ");
        }
        return stringBuffer.toString();
    }
}
