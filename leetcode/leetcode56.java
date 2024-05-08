/*
Leetcode 56 - Merge Intervals (medium)
https://leetcode.com/problems/merge-intervals/

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and 
return an array of the non-overlapping intervals that cover all the intervals in the input.
 

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:
1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104

*/

class Solution {
    public int[][] merge(int[][] intervals) {
        // base case(s)
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // sort arrays
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        // new arraylist object for dynamic sizing (regular arrays have a fixed length)
        List<int[]> newLst = new ArrayList<>();
        newLst.add(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++){
            int[] lastElem = newLst.get(newLst.size() - 1);
            /* if the ending interval value of the last element in our Arraylist is greater than or equal to the starting 
                interval value of the current element in the original array, then they overlap */
            if(lastElem[1] >= intervals[i][0]) {
                lastElem[1] = Math.max(lastElem[1], intervals[i][1]);
            }
            // if they do not overlap, we add the current interval from the original array to the arraylist
            else {
                newLst.add(intervals[i]);
            }
        }

        // convert to a 2d array and return
        return newLst.toArray(new int[newLst.size()][2]);
    }
}


/* I came up with two python versions of the solution as well 
 python lists are mutable unlike java arrays so in my first implementation I avoid creating another temporary array
a temporary array can occupy a lot of memory especially when your original input is large, 
  so rather than creating a copy, editing the current one is more space efficient */

class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda x: x[0])

        n = 0
        while(n < len(intervals) - 1):
            if intervals[n+1][0] <= intervals[n][1]:
                intervals[n][1] = max(intervals[n+1][1], intervals[n][1])
                intervals.remove(intervals[n+1])
            
            else:
                n = n + 1
    
        return intervals

        
class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda x: x[0])
        merged = [intervals[0]]

        for interval in intervals:
            if merged[-1][1] < interval[0]:
                merged.append(interval)
            else:
                merged[-1][1] = max(merged[-1][1], interval[1])

        return merged


