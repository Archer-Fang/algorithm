package PartThree.q49;

import com.sun.deploy.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Created by Fangzj
 * @data 2021/5/8 21:16
 **/
//class Solution {
//    public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> ans=new LinkedList<>();
//        HashMap<String, List<String>> listHashMap = new HashMap<>();
//        for (int i = 0; i < strs.length; i++) {
//            int[] key=new int[26];
//            for (char ch:
//                strs[i].toCharArray() ) {
//                key[ch-'a']++;
//            }
//            StringBuffer stringBuffer = new StringBuffer();
//            for (Integer tmp:key
//                 ) {
//                stringBuffer.append(tmp+" ");
//            }
//            List<String> list = listHashMap.getOrDefault(stringBuffer.toString(), new LinkedList<>());
//            list.add(strs[i]);
//            listHashMap.put(stringBuffer.toString(),list);
//        }
//        for ( String tmp:
//        listHashMap.keySet()) {
//            ans.add(listHashMap.get(tmp));
//        }
//        return ans;
//    }
//}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    int[] counter = new int[26];
                    for (int i = 0; i < str.length(); i++) {
                        counter[str.charAt(i) - 'a']++;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < 26; i++) {
                        // 这里的 if 是可省略的，但是加上 if 以后，生成的 sb 更短，后续 groupingBy 会更快。
                        if (counter[i] != 0) {
                            sb.append((char) ('a' + i));
                            sb.append(counter[i]);
                        }
                    }
                    return sb.toString();
                })).values());

    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.groupAnagrams(new String[]{"bdddddddddd","bbbbbbbbbbc"}));
        System.out.println(solution.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
