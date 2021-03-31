package PartOne.PreTree.q208;

/**
 * @author Created by Fangzj
 * @data 2021/3/11 21:26
 **/

class Trie {
    private class TrieNode{
        TrieNode[] children;
        int count;
        int preCount;

        public TrieNode() {
            children=new TrieNode[26];
            count=0;
            preCount=0;
        }
    }
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node=root;
        for (int i=0;i<word.length();i++){
            if (node.children[word.charAt(i) - 'a'] == null) node.children[word.charAt(i) - 'a']=new TrieNode();
            node=node.children[word.charAt(i) - 'a'];
            node.preCount++;
        }
        node.count++;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node=root;
        for (int i=0;i<word.length();i++){
            if (node.children[word.charAt(i) - 'a'] == null) return false;
            node=node.children[word.charAt(i) - 'a'];
        }
        return node.count>0;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node=root;
        for (int i=0;i<prefix.length();i++){
            if (node.children[prefix.charAt(i) - 'a'] == null) return false;
            node=node.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
public class q208 {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));


    }
}
