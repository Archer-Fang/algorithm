"""
Problem Statement
=================
Count number of binary search trees created for array of size n. The solution is the nth catalan number.


Complexity
----------
* Dynamic Programming: O(n^2)
* Recursive Solution: O(2^n)

Video
-----

* https://youtu.be/YDf982Lb84o

Reference
---------
* http://www.geeksforgeeks.org/program-nth-catalan-number/
"""


def num_bst(num_nodes):
    T = [0 for _ in range(num_nodes + 1)]
    T[0] = 1
    T[1] = 1

    for node in range(2, num_nodes+1):
        for sub in range(0, node):
            T[node] += T[sub] * T[node - sub - 1]

    return T[num_nodes]





if __name__ == '__main__':
    assert 5 == num_bst(3)
