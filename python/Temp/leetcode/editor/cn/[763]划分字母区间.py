#coding=utf-8
from typing import List

# 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。 
# 
#  
# 
#  示例： 
# 
#  
# 输入：S = "ababcbacadefegdehijhklij"
# 输出：[9,7,8]
# 解释：
# 划分结果为 "ababcbaca", "defegde", "hijhklij"。
# 每个字母最多出现在一个片段中。
# 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
#  
# 
#  
# 
#  提示： 
# 
#  
#  S的长度在[1, 500]之间。 
#  S只包含小写字母 "a" 到 'z' 。 
#  
#  Related Topics 贪心 哈希表 双指针 字符串 👍 664 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        pos=[0]*26
        ans=[]

        for i in range(len(s)):
            pos[ord(s[i])-ord("a")]=max(pos[ord(s[i])-ord("a")],i)
        max_p=0
        l=-1
        for i in range(len(s)):
            max_p=max(max_p,pos[ord(s[i])-ord("a")])
            if max_p==i:
                if len(ans)==0:
                    ans.append(max_p-l)
                    l=max_p
                else:
                    ans.append(max_p-l)
                    l = max_p
        return ans


# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    s=Solution()
    print(s.partitionLabels("ababcbacadefegdehijhklij"))