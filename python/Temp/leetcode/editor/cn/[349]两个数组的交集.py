# 给定两个数组，编写一个函数来计算它们的交集。 
# 
#  
# 
#  示例 1： 
# 
#  输入：nums1 = [1,2,2,1], nums2 = [2,2]
# 输出：[2]
#  
# 
#  示例 2： 
# 
#  输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
# 输出：[9,4] 
# 
#  
# 
#  说明： 
# 
#  
#  输出结果中的每个元素一定是唯一的。 
#  我们可以不考虑输出结果的顺序。 
#  
#  Related Topics 数组 哈希表 双指针 二分查找 排序 👍 452 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        s1 = set(num for num in nums1)
        s2 = set(num for num in nums2)
        return list(s1 & s2)


# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    s = Solution()
    print(s.intersection([1, 2, 2, 1], [2, 2]))