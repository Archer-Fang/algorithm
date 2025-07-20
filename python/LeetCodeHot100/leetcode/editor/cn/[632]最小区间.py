#!/usr/bin/env python
#coding=utf-8
from typing import List
import heapq
import math
# 你有 k 个 非递减排列 的整数列表。找到一个 最小 区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
# 
#  我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：nums = [[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
# 输出：[20,24]
# 解释： 
# 列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
# 列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
# 列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
#  
# 
#  示例 2： 
# 
#  
# 输入：nums = [[1,2,3],[1,2,3],[1,2,3]]
# 输出：[1,1]
#  
# 
#  
# 
#  提示： 
# 
#  
#  nums.length == k 
#  1 <= k <= 3500 
#  1 <= nums[i].length <= 50 
#  -10⁵ <= nums[i][j] <= 10⁵ 
#  nums[i] 按非递减顺序排列 
#  
# 
#  
# 
#  Related Topics 贪心 数组 哈希表 排序 滑动窗口 堆（优先队列） 👍 478 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def smallestRange(self, nums: List[List[int]]) -> List[int]:
        """
        Finds the smallest range that includes at least one number from each of the k sorted lists.

        :param nums: A list of k sorted lists of integers
        :return: A list of two integers representing the range [l, r]
        """
        # Initialize the range [l, r] with very large values
        l, r = -10 ** 5, 10 ** 5

        # Min-heap to track the smallest element among the current elements of the lists
        min_heap = []

        # Track the current maximum value in the heap
        max_v = float('-inf')

        # Add the first element of each list to the heap and update max_v
        for i in range(len(nums)):
            item = nums[i][0]  # First element of the current list
            heapq.heappush(min_heap, (item, i, 0))  # Push (value, list index, element index) to the heap
            max_v = max(max_v, item)  # Update the maximum value

        # Process the heap to find the smallest range
        while True:
            # Extract the smallest element from the heap
            min_v, row, col = heapq.heappop(min_heap)

            # Check if the current range is smaller than the previously recorded range
            if max_v - min_v < r - l:
                l, r = min_v, max_v  # Update the range

            # If we've reached the end of one of the lists, return the current range
            if col == len(nums[row]) - 1:
                return [l, r]

            # Add the next element of the same list to the heap
            next_val = nums[row][col + 1]
            heapq.heappush(min_heap, (next_val, row, col + 1))

            # Update the maximum value in the heap
            max_v = max(max_v, next_val)

# class Solution:
#     def smallestRange(self, nums: List[List[int]]) -> List[int]:
#         all_num=[nums[i][j] for i in range(len(nums)) for j in range(len(nums[i]))  ]
#         heapq.heapify(all_num)
#         ans=[]
#         while all_num:
#             max_num=heapq.heappop(all_num)
#             is_in_num_list=False
#             for i,num in enumerate(nums):
#                 if max_num<num[0]:
#                     break
#                 if i==len(nums)-1:
#                     is_in_num_list=True
#             if is_in_num_list:
#                 ans.append(max_num)
#         all_num2=[-ans[i] for i in range(len(ans)) ]
#         ans2=[]
#         heapq.heapify(all_num2)
#         while all_num2:
#             max_num=-heapq.heappop(all_num2)
#             is_in_num_list=False
#             for i,num in enumerate(nums):
#                 if max_num>num[len(num)-1]:
#                     break
#                 if i==len(nums)-1:
#                     is_in_num_list=True
#             if is_in_num_list:
#                 ans2.append(max_num)
#
#         if len(ans2)==1:
#             return [ans2[0],ans2[0]]
#         min=99999999999999999999999999999
#         for i in range(len(ans2)-2):
#             if ans2[i+1]-ans2[i]<=min:
#                 min=self.min(ans2[i+1]-ans2[i],min)
#                 result=[ans2[i+1],ans2[i]]
#         return result
#     def min(self,i,j):
#         if i<j:
#             return i
#         return j
# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s=Solution()
    nums=[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
    r=s.smallestRange(nums)
    # for num in nums:
    #     flag=False
    #     for item in num:
    #         if item>=r[0] and item<=r[1]:
    #             flag = True
    #             continue
    #
    #     if not flag:
    #         print(r)
    #         print(num)

    print(r)