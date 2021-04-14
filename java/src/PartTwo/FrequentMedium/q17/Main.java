package PartTwo.FrequentMedium.q17;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Created by Fangzj
 * @data 2021/4/14 16:20
 **/
class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new LinkedList<>();
        HashMap<Integer,String[]> map=new HashMap<>();
        map.put(2,new String[]{"a","b","c"});
        map.put(3,new String[]{"d","e","f"});
        map.put(4,new String[]{"g","h","i"});
        map.put(5,new String[]{"j","k","l"});
        map.put(6,new String[]{"m","n","o"});
        map.put(7,new String[]{"p","q","r","s"});
        map.put(8,new String[]{"t","u","v"});
        map.put(9,new String[]{"w","x","y","z"});

        List<String> ans=new LinkedList<>();
        dfs(digits,map,ans,"");
        return ans;
    }
    public void dfs(String digits,HashMap<Integer,String[]> map,List<String> ans,String path){
        if(digits.length()==0) return;
        if(digits.length()==1) {
            int num=Integer.parseInt(digits);
            String[] tmp=map.get(num);
            for (int i=0;i<tmp.length;i++){
                ans.add(path+map.get(num)[i]);
            }
        }
        int num=Integer.parseInt(String.valueOf(digits.charAt(0)));
        String[] tmp=map.get(num);
        for (int i=0;i<tmp.length;i++){
            dfs(digits.substring(1,digits.length()),map,ans,path+map.get(num)[i]);
        }

    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.letterCombinations("23"));
        System.out.println(solution.letterCombinations("7"));
    }
}
