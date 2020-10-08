"""
掉鸡蛋问题。
实质还是01背包问题
先初始化：

Problem Statement
=================

Given a certain number of eggs and a certain number of floors, determine the minimum number of attempts required to find
the egg breaking floor.

Analysis
--------

* Dynamic Programming Time Complexity: O(eggs * num_floors^2)
* Recursive Solution: Exponential

Video
-----

* https://youtu.be/3hcaVyX00_4

Reference
---------

* http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/

"""


def min_attempts_egg_drop(eggs, floors):
    rows=eggs+1
    cols=floors+1
    T=[[col if row==1 else 0 for col in range(cols)] for row in range(rows)]
    for i in range(1,rows):
        T[i][1]=1
    for row in range(2,rows):
        for col in range(2,cols):
            if row>col:
                T[row][col]=T[row-1][col]
            else:
                 T[row][col]=min(1+max(T[row-1][k-1],T[row][col-k]) for k in range(1,col+1))
    return T[-1][-1]


if __name__ == '__main__':
    #add 
    eggs = 2
    floors = 6
    expected_attempts = 3

    assert expected_attempts == min_attempts_egg_drop(eggs, floors)
    eggs = 3
    floors = 100
    expected_attempts = 9

    assert expected_attempts == min_attempts_egg_drop(eggs, floors)

