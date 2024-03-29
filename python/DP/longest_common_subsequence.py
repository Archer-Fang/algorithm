"""
Problem Statement
=================

Given two sequences A = [A1, A2, A3,..., An] and B = [B1, B2, B3,..., Bm], find the length of the longest common
subsequence.

Video
-----

* https://youtu.be/NnD96abizww

Complexity
----------

* Recursive Solution: O(2^n) (or O(2^m) whichever of n and m is larger).
* Dynamic Programming Solution: O(n * m)

Reference
---------

* https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
* http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
"""



def longest_common_subsequence(sequence1, sequence2):
    cols = len(sequence1) + 1   # Add 1 to represent 0 valued column for PartOne.DP
    rows = len(sequence2) + 1   # Add 1 to represent 0 valued row for PartOne.DP

    T = [[0 for _ in range(cols)] for _ in range(rows)]

    max_length = 0

    for i in range(1, rows):
        for j in range(1, cols):
            if sequence2[i - 1] == sequence1[j - 1]:
                T[i][j] = 1 + T[i - 1][j - 1]
            else:
                T[i][j] = max(T[i - 1][j], T[i][j - 1])

            max_length = max(max_length, T[i][j])

    return max_length


if __name__ == '__main__':
    sequence1 = "ABCDGHLQR"
    sequence2 = "AEDPHR"
    expected_length = 4

    assert expected_length == longest_common_subsequence(sequence1, sequence2)
    assert expected_length == longest_common_subsequence(sequence2, sequence1)
