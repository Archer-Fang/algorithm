"""
Problem Statement
=================

Given coins of certain denominations with infinite supply find minimum number of coins it takes to form given total

Video
-----


* Bottom up PartOne.DP - https://youtu.be/NJuKJ8sasGk (Same as Approach 1. Uses 1D array since 2D array is not required.)

Analysis
--------

* Time complexity - O(len(coins) * total)
* Space complexity - O(len(coins) * total)
"""


def min_coins(coins, total):
    cols = total + 1
    rows = len(coins)+1
    T = [[0 if col == 0 else float("inf") for col in range(cols)] for _ in range(rows)]

    for i in range(rows):
        for j in range(1, cols):
            if j < coins[i]:
                T[i][j] = T[i - 1][j]
            else:
                T[i][j] = min(T[i - 1][j], 1 + T[i][j - coins[i]])

    return T[rows - 1][cols - 1]




if __name__ == '__main__':
    coins = [1, 5, 6, 8]
    total = 11
    expected = 2
    assert expected == min_coins(coins, total)
    