package PreTree.q648;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by Fangzj
 * @data 2021/3/12 15:57
 **/

class Solution {
    private class TrieNode{
        TrieNode[] children;
        String word;

        public TrieNode() {
            children=new TrieNode[26];
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root=new TrieNode();
        for (String item:dictionary){
            TrieNode node=root;
            for (int i=0;i<item.length();i++){
                if(node.children[item.charAt(i)-'a']==null) node.children[item.charAt(i)-'a']=new TrieNode();
                node=node.children[item.charAt(i)-'a'];
            }
            node.word=item;
        }
        String[] words=sentence.split(" ");
        StringBuffer sb=new StringBuffer();
        for (String word:words){
            TrieNode node=root;
            for (int i=0;i<word.length();i++){
                if(node.children[word.charAt(i)-'a']==null||node.word!=null){
                    break;
                }
                else node=node.children[word.charAt(i)-'a'];
            }
            sb.append(node.word==null?word+" ":node.word+" ");
        }
        return sb.deleteCharAt(sb.lastIndexOf( " ")).toString();
    }
}

public class q648 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        List<String> dictionary=new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");


        System.out.println(solution.replaceWords(dictionary,"the cattle was rattled by the battery"));
    }
}
