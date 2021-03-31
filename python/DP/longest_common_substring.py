"""
Problem Statement
=================

Given two sequences A = [A1, A2, A3,..., An] and B = [B1, B2, B3,..., Bm], find the length of the longest common
substring.

Video
-----

* https://youtu.be/BysNXJHzCEs

Complexity
----------

* Recursive Solution: O(2^n) (or O(2^m) whichever of n and m is larger).
* Dynamic Programming Solution: O(n * m)

Reference
---------

* http://en.wikipedia.org/wiki/Longest_common_substring_problem
"""




def longest_common_substring(str1, str2):
    cols = len(str1) + 1     # Add 1 to represent 0 valued col for PartOne.DP
    rows = len(str2) + 1     # Add 1 to represent 0 valued row for PartOne.DP

    T = [[0 for _ in range(cols)] for _ in range(rows)]

    max_length = 0

    for i in range(1, rows):
        for j in range(1, cols):
            if str2[i - 1] == str1[j - 1]:
                T[i][j] = T[i - 1][j - 1] + 1
                max_length = max(max_length, T[i][j])

    return max_length


if __name__ == '__main__':
    str1 = "abcdef"
    str2 = "zcdemf"
    expected = 3
    assert expected == longest_common_substring(str1, str2)
    str1 = "abcdef"
    str2 = "cde"
    expected = 3
    assert expected == longest_common_substring(str1, str2)
    str1 = "cde"
    str2 = "zcdemf"
    expected = 3
    assert expected == longest_common_substring(str1, str2)

