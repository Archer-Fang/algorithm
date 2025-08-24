#!/usr/bin/env python
#coding=utf-8
from typing import List

# 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
# 
#  给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
# 
#  
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：digits = "23"
# 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
#  
# 
#  示例 2： 
# 
#  
# 输入：digits = ""
# 输出：[]
#  
# 
#  示例 3： 
# 
#  
# 输入：digits = "2"
# 输出：["a","b","c"]
#  
# 
#  
# 
#  提示： 
# 
#  
#  0 <= digits.length <= 4 
#  digits[i] 是范围 ['2', '9'] 的一个数字。 
#  
# 
#  Related Topics 哈希表 字符串 回溯 👍 3105 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if len(digits)==0:
            return []
        self.phone_map = {
            1: "",  # 通常1不对应任何字母
            2: "abc",
            3: "def",
            4: "ghi",
            5: "jkl",
            6: "mno",
            7: "pqrs",
            8: "tuv",
            9: "wxyz"
        }
        self.ans_list=[]
        ans=[]
        self.dfs(ans,0,digits)
        return self.ans_list
    def dfs(self, ans, index,digits):
        if index==len(digits):
            self.ans_list.append("".join(ans[:]))
            return

        alpha_list=self.phone_map.get(int(digits[index]))
        for alpha in alpha_list:
            ans.append(alpha)
            self.dfs(ans,index+1,digits)
            ans.pop()
        return None


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s=Solution()
    print(s.letterCombinations("23"))