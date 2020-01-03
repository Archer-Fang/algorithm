"""
Problem Statement
=================

Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
Determine the maximum value obtainable by cutting up the rod and selling the pieces.

Video
-----

* https://youtu.be/IRwVmTmN6go


Time Complexity
---------------

1. Recursive Solution = O(2^n)
2. Dynamic Programming Solution = O(n^2)

Reference
---------
http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
"""





#01背包模板
def get_max_v(price_list,n):
    rows = n + 1
    cols = n + 1
    T = [[0 for _ in range(cols)] for _ in range(rows)]
    for i in range(1,rows):
        for j in range(1,cols):
            if j<i:
                T[i][j]=T[i-1][j]
            else:
                #T[i][j] = max(T[i - 1][j], values[i - 1] + T[i - 1][j - weights[i - 1]])
                T[i][j]=max(T[i-1][j],T[i][j-i]+price_list[i-1])
    return T[rows - 1][cols -1]


#降低空间复杂度
def max_profit_dp(prices, rod_length):
    rod_length_values = [0 for _ in range(rod_length + 1)]

    for length in range(1, rod_length + 1):

        max_value = float("-inf")

        for cut_length in range(1, length + 1):
            max_value = max(max_value, prices[cut_length - 1] + rod_length_values[length - cut_length])

        rod_length_values[length] = max_value

    return rod_length_values[rod_length]
if __name__ == '__main__':
    prices = [3,5,8,9,10,20,22,25]
    rod_length = 8
    expected_max_profit = 26
    assert expected_max_profit == max_profit_dp(prices, rod_length)
    assert expected_max_profit == get_max_v(prices, rod_length)
