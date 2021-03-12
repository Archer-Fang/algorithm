package PreTree.q820;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Created by Fangzj
 * @data 2021/3/12 16:17
 **/
class Solution {
    private class Trie {
        private class TrieNode {
            TrieNode[] children;
            Boolean isNew;
            public TrieNode() {
                children = new TrieNode[26];
                isNew=false;
            }
        }
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                if (node.children[word.charAt(i) - 'a'] == null) node.children[word.charAt(i) - 'a'] = new TrieNode();
                node = node.children[word.charAt(i) - 'a'];
            }
        }

        public int search(TrieNode root) {

            int c=0;

            List<Integer> deepList=new LinkedList<>();

            dfs(root,0,deepList);

            for (Integer i:deepList) c+=i;
            c+=deepList.size();
            return c;
        }
        public void dfs(TrieNode root, int deep, List<Integer> deepList) {
            int i=0;
            for(TrieNode node:root.children){
                if(node==null) i++;
                if(node!=null) dfs(node,deep+1,deepList);
            }
            if(i==26) deepList.add(deep);
        }
    }



    public int minimumLengthEncoding(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            String sb = new StringBuffer(word).reverse().toString();
            trie.insert(sb);
        }
        return trie.search(trie.root);
    }
}

public class q820 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.minimumLengthEncoding(new String[]{"time","atime","btime"}));
    }
}
