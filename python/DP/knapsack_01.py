"""
Problem Statement
=================

0/1 Knapsack Problem - Given items of certain weights/values and maximum allowed weight how to pick items to pick items
from this set to maximize sum of value of items such that sum of weights is less than or equal to maximum allowed
weight.
* http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/

Runtime Analysis
----------------
Time complexity - O(W*total items)

Video
-----
* Topdown PartOne.DP - https://youtu.be/149WSzQ4E1g
* Bottomup PartOne.DP - https://youtu.be/8LusJS5-AGo

References
----------
* https://en.wikipedia.org/wiki/Knapsack_problem
"""

#01背包问题。
def knapsack_01(values, weights, total):
    total_items = len(weights)

    rows = total_items + 1
    cols = total + 1

    T = [[0 for _ in range(cols)] for _ in range(rows)]

    for i in range(1, rows):
        for j in range(1, cols):
            if j < weights[i - 1]:#目标w的总重《当前背包重量,不拿当前背包
                T[i][j] = T[i - 1][j]
            else:#目标w的总重《当前背包重量,判断要不要拿当前背包，拿的v跟不拿的v取最大，（二选一，因为价值不一样
                T[i][j] = max(T[i - 1][j], values[i - 1] + T[i - 1][j - weights[i - 1]])

    return T[rows - 1][cols -1]


if __name__ == '__main__':
    total_weight = 7
    weights = [1, 3, 4, 5]
    values = [1, 4, 5, 7]
    expected = 9
    assert expected == knapsack_01(values, weights, total_weight)
    total_weight = 8
    weights = [2, 2, 4, 5]
    values = [2, 4, 6, 9]
    expected = 13
    assert expected == knapsack_01(values, weights, total_weight)
    
    weights = [1, 2, 3]
    values = [1, 2, 3]
    total_weight = 5
    expected = 5
    assert expected == knapsack_01(values, weights, total_weight)