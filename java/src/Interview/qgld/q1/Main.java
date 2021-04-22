package Interview.qgld.q1;

/**
 * @author Created by Fangzj
 * @data 2021/4/21 19:44
 **/

import java.security.KeyStore;
import java.util.*;

class Solution {
    public Boolean needNum(int[] nums) {
        //一有结果直接sout
        HashMap<Integer,Integer> hashMap=new HashMap();
        for (Integer tmp:nums){
            hashMap.put(tmp,hashMap.getOrDefault(tmp,0)+1);
        }
        if(hashMap.size()==2){
            int i=0,j=0;
            for (Integer tmp:hashMap.keySet()){
                if(i!=0){
                    return i==hashMap.get(tmp);
                }
                else i=hashMap.get(tmp);
            }
            return false;
        }
        else return false;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        while ((T--) > 0) {
            int n = Integer.parseInt(in.nextLine());
            int[] d1 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(solution.needNum(d1)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }

    }
}
//1
//3 3
//3
//6
//9


//3
//6
//2 3 3 3 2 1
//2
//1 1
//6
//1 1 2 2 3 3