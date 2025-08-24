#!/usr/bin/env python
#coding=utf-8
from typing import List

# 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
# 
#  candidates 中的每个数字在每个组合中只能使用 一次 。 
# 
#  注意：解集不能包含重复的组合。 
# 
#  
# 
#  示例 1: 
# 
#  
# 输入: candidates = [10,1,2,7,6,1,5], target = 8,
# 输出:
# [
# [1,1,6],
# [1,2,5],
# [1,7],
# [2,6]
# ] 
# 
#  示例 2: 
# 
#  
# 输入: candidates = [2,5,2,1,2], target = 5,
# 输出:
# [
# [1,2,2],
# [5]
# ] 
# 
#  
# 
#  提示: 
# 
#  
#  1 <= candidates.length <= 100 
#  1 <= candidates[i] <= 50 
#  1 <= target <= 30 
#  
# 
#  Related Topics 数组 回溯 👍 1693 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        if target == 0 or not candidates:
            return []
        self.ans_list = []
        candidates.sort()
        self.dfs(candidates, target, 0, [])
        return self.ans_list

    def dfs(self, candidates, target, index, ans):
        if target == 0:
            self.ans_list.append(ans[:])
            return
        dup=set()
        for i in range(index, len(candidates)):
            if target < candidates[i]:
                break
            if candidates[i] in dup:
                continue
            ans.append(candidates[i])
            self.dfs(candidates, target - candidates[i], i+1, ans)
            ans.pop()
            dup.add(candidates[i])


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s=Solution()
    print(s.combinationSum2(candidates = [10,1,2,7,6,1,5], target = 8))