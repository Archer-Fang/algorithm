"""
Problem Statement
=================

Given two strings str1 and str2, find the minimum number of edits (edit one character to another, delete char from str1
or delete char from str2) to change str1 to str2.

Video
-----
* https://youtu.be/We3YDTzNXEk

Analysis
--------
* PartOne.DP Runtime : O(len(str1) * len(str2))
* Recursive Solution: Exponential (O(3^(m+n-1)))

Reference
---------
* https://www.clear.rice.edu/comp130/12spring/editdist/
"""


   




def min_edit_distance(str1,str2):
    T=[[0 for col in range(len(str2)+1)] for row in range(len(str1)+1)]
    #初始化
    for row in range(len(T)):
        for col in range(len(T[0])):
            if row==0:
                T[row][col]=col
            if col==0:
                T[row][col]=row
    for row in range(1,len(T)):
        for col in range(1,len(T[0])):
            if str1[row-1]!=str2[col-1]:
                T[row][col]=min(T[row][col-1],T[row-1][col],T[row-1][col-1])+1
            else:
                T[row][col]=min(T[row][col-1],T[row-1][col],T[row-1][col-1])
    return T[-1][-1]


if __name__ == '__main__':
    str1 = "azced"
    str2 = "abcdef"
    expected = 3
    assert expected == min_edit_distance(str1, str2)
