package DFS.q842;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Created by Fangzj
 * @data 2021/3/13 22:06
 **/
class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ans=new LinkedList<>();
        backtrace(S.toCharArray(),0,ans);
        return ans;

    }
    public Boolean backtrace(char[] number,int index,List<Integer> ans){
        if(index==number.length&&ans.size()>=3) return true;

        for (int i=index;i<number.length;i++){
            if (number[index] == '0' && i > index) {
                break;
            }
            long num=getNumber(number,index,i);
            if(num>Integer.MAX_VALUE) break;
            int size=ans.size();
            if (size >= 2 && num > (ans.get(size - 1) + ans.get(size - 2))) {
                break;
            }

            if(size==1||size==0||size>=2&&num== ans.get(size - 1) + ans.get(size - 2)){
                ans.add((int) num);
                if(backtrace(number,i+1,ans)){
                    return true;
                }
                ans.remove(ans.size()-1);
                
            }
        }
        return false;
    }

    private long getNumber(char[] number, int index, int i) {
        if(index==i) return number[index]-'0';
        long num = 0;
        for (int j=index;j<=i;j++){
            num=10*num+number[j]-'0';
        }
        return num;
    }
}

public class q842 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.splitIntoFibonacci("123456579"));
    }
}
