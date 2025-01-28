# https://leetcode.com/problems/insert-interval/
'''
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.

 

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 

Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
'''

class Solution:
    def insert(self, intervals: list[list[int]], newInterval: list[int]) -> list[list[int]]:

        if len(intervals) == 0:
            return [newInterval]
        
        answer = [ ]
        added_new = False
        for int in intervals:
            # interval comes before new interval
            if int[1] < newInterval[0]: 
                answer.append(int)
            # interval comes after new interval
            elif int[0] > newInterval[1]:
                if not added_new:
                    answer.append(newInterval)
                    added_new = True 
                answer.append(int)
            else: # overlap combine intervals
                newInterval[0] = min(int[0], newInterval[0])
                newInterval[1] = max(int[1], newInterval[1])

        if not added_new:
            answer.append(newInterval)
        return answer


if __name__ == "__main__":
    s = Solution()
    print(s.insert([[1,3],[6,9]], [2,5]))
    print(s.insert([[1,2],[3,5],[6,7],[8,10],[12,16]],[4,8]))