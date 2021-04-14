package PartTwo.FrequentMedium.q22;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Created by Fangzj
 * @data 2021/4/14 16:53
 **/
class Solution {
    List<String> ans=new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n,n,"");
        return ans;
    }
    public void dfs(int left,int right,String path){
        if(left==right&&right==0){
            ans.add(path);
        }
        if(left>0){
            dfs(left-1,right,path+"(");
        }
        if(right>left){
            dfs(left,right-1,path+")");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println(-1);
    }
}
