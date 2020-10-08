"""
Problem Statement
=================

Given set of jobs with start and end interval and profit, how to maximize profit such that jobs in subset do not
overlap.

Video
-----
* https://youtu.be/cr6Ip0J9izc

Complexity
----------

* Runtime Complexity: O(n^2)
* Space Complexity: O(n)

Reference Link
--------------
* http://www.cs.princeton.edu/courses/archive/spr05/cos423/lectures/06dynamic-programming.pdf
"""



def can_sequence(job1,job2):
    _,finish=job1
    start,_=job2
    return finish<=start

def find_max_jobs(jobs):
    sequence_jobs=sorted(jobs.keys(),key=lambda x:x[1])
    T=[jobs[sequence_job] for sequence_job in sequence_jobs]
    for i in range(1,len(sequence_jobs)):
        for j in range(0,i):
            if can_sequence(sequence_jobs[j],sequence_jobs[i]):
                T[i]=max(T[i],(jobs[sequence_jobs[i]]+T[j]))
    return max(T)
if __name__ == '__main__':
    jobs = {
        (1, 3): 5,      # (start_time, end_time, total_cost)
        (2, 5): 6,
        (4, 6): 5,
        (6, 7): 4,
        (5, 8): 11,
        (7, 9): 2
    }

    # assert 17 == find_max_profit(jobs)
    print(find_max_jobs(jobs))

    #安排的活动数最多
    jobs = {
        (1, 3): 1,      # (start_time, end_time, total_cost)
        (2, 5): 1,
        (4, 6): 1,
        (6, 7): 1,
        (5, 8): 1,
        (7, 9): 1
    }

    # assert 17 == find_max_profit(jobs)
    print(find_max_jobs(jobs))
