package DFS.q816;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Created by Fangzj
 * @data 2021/3/14 21:00
 **/
class Solution {
    public List<String> ambiguousCoordinates(String S) {
        S=S.substring(1,S.length()-1);
        List<String> ans=new LinkedList<>();
        for (int i=1;i<S.length();i++){
            for(String left:make(S.substring(0,i))){
                for(String right:make(S.substring(i,S.length()))){


                    ans.add("("+left+", "+right+")");
                }
            }
        }
        return ans;
    }
    public List<String> make(String S) {
        List<String> S1=new LinkedList<>();
        for (int i=0;i<S.length();i++){
            if(S.substring(0,i+1).startsWith("0")&&S.substring(0,i+1).length()>1) continue;
            if(i==S.length()-1){
                S1.add(S.substring(0,i+1));
            }
            else {
                if(Integer.parseInt(S.substring(i+1,S.length()))==0||S.substring(i+1,S.length()).endsWith("0")) continue;
                else S1.add(S.substring(0,i+1)+"."+S.substring(i+1,S.length()));
            }
        }
        return S1;

    }
}
public class q816 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.ambiguousCoordinates("(0123)"));
    }
    //"00", "001", "00.01", "0.0", "1.0", "0.00"

}
