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

def dp_min_space(price_list,n):
    rod_length_values = [0 for _ in range(rod_length + 1)]
    for i in range(1,n+1):
        max_v=float('-inf')
        for j in range(1,i+1):
            max_v=max(max_v,price_list[j-1]+rod_length_values[i-j])
        rod_length_values[i]=max_v
    return rod_length_values[-1]

#01背包模板
def get_max_v(price_list,n):
    rows = n + 1
    cols = n + 1
    T = [[0 for _ in range(cols)] for _ in range(rows)]
    for j in range(len(T[0])):
        T[1][j]=j*price_list[0]
    for i in range(2,len(T)):
        T[i][1]=T[i-1][1]
    for i in range(2,rows):
        for j in range(2,cols):
            if j<i:
                T[i][j]=T[i-1][j]
            else:
                #T[i][j] = max(T[i - 1][j], values[i - 1] + T[i - 1][j - weights[i - 1]])
                T[i][j]=max(T[i-1][j],T[i][j-i]+price_list[i-1])
    return T[rows - 1][cols -1]



if __name__ == '__main__':
    prices = [3,5,8,9,10,20,22,25]
    rod_length = 8
    expected_max_profit = 26
    assert expected_max_profit == dp_min_space(prices, rod_length)
    assert expected_max_profit == get_max_v(prices, rod_length)
