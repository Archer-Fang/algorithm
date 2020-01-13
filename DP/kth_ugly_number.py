"""
Problem Statement
=================

Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15,
shows the first 11 ugly numbers. By convention, 1 is included.

Write a program to find the kth ugly number.

Complexity
----------

* Time Complexity O(n)
* Space Complexity O(n)

Reference
---------
* http://www.geeksforgeeks.org/ugly-numbers/
"""



def GetUglyNumber_Solution(index):
    if index < 1:
        return 0
    res = [1]
    #用来记录*2，3，5的次数
    t2,t3,t5 = 0,0,0
    while len(res) < index:
        minNum = (min(res[t2]*2, res[t3]*3, res[t5]*5))
        if minNum > res[-1]: 
            res.append(minNum)
        if (res[-1] == res[t2]*2): t2 += 1
        elif (res[-1] == res[t3]*3): t3 += 1
        else: t5 += 1
    return res[-1]

if __name__ == '__main__':
    assert 5832 == GetUglyNumber_Solution(150)
