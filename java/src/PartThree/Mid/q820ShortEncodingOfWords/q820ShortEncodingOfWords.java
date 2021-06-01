package PartThree.Mid.q820ShortEncodingOfWords;
//Java：单词的压缩编码

import java.util.LinkedList;

public class q820ShortEncodingOfWords{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.minimumLengthEncoding(new String[]{"time", "me", "bell"}));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumLengthEncoding(String[] words) {
        StringBuffer stringBuffer = new StringBuffer();
        PreTree preTree = new PreTree();
        for (String word : words) {
            preTree.addWord(word);
        }
        return preTree.getLength(preTree.root);
    }
}
class PreTree{
    class Node{
        Node[] children;
        public Node() {
            this.children = new Node[26];
        }
    }
    Node root;
    public PreTree() {
        this.root = new Node();
    }
    public void addWord(String word){
        Node cur=root;

        char[] chars=word.toCharArray();
        for (int i = chars.length-1; i >-1 ; i--) {
            if(cur.children[chars[i]-'a']==null){
                cur.children[chars[i]-'a']=new Node();
            }
            cur=cur.children[chars[i]-'a'];
        }
    }
    public int getLength(Node root){

        LinkedList<Integer> list = new LinkedList<>();
        dfs(root,0,list);
        return list.stream().reduce((a,b)->a+b).get();
    }
    public void dfs(Node root, int deep, LinkedList<Integer> list){
        int i=0;
        for (Node node : root.children) {
            if(node==null) {i++;continue;}
            dfs(node,deep+1,list);
        }
        if(i==26) list.add(deep==0?0:deep+1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
