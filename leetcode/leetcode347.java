/*
Leetcode 347: Top K Frequent Elements (medium)
https://leetcode.com/problems/top-k-frequent-elements/

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique

*/


/*
Approach #1: sorted array and treemap to map frequencies

Leetcode Stats: runtime 9s, memory 46.14mb
O(nlogn) time complexity - depending on sorting algorithm, time complexity may change + need to iterate through the map and copy down values into the resulting array

*/



import java.util.*; 
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //sort all the values in nums so that repeating numbers are next to one another
        Arrays.sort(nums);

        //Treemap of counts
        TreeMap<Integer, HashSet<Integer>> frequencies = new TreeMap<Integer, HashSet<Integer>>(Collections.reverseOrder());
        int prev = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prev) {
                HashSet<Integer> newInput = frequencies.getOrDefault(count, new HashSet<>());
                newInput.add(prev);
                frequencies.put(count, newInput);
                count = 1;
                prev = nums[i];
            }
            else{
                count++;
            }
        }
        HashSet<Integer> newInput = frequencies.getOrDefault(count, new HashSet<>());
        newInput.add(prev);
        frequencies.put(count, newInput);

        // go through treemap and add values to the final array
        int[] result = new int[k];
        int currIndex = 0;
        for(int n : frequencies.keySet()) {
            for (int x : frequencies.get(n)) {
                result[currIndex] = x;
                currIndex++;
                if (--k == 0) {
                    return result;
                }
            }
        }

        return result;

    }
}






/*
Approach #2: HashMap to map frequencies then sorting the hashmap
Leetcode Stats: runtime 16ms, memory 48.74mb
*/

import java.util.*; 
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> counts = new HashMap<Integer,Integer>();
        for (int i : nums) {
            counts.put(i, counts.getOrDefault(i, 0) + 1);
        }
        

        List<Integer> list = new ArrayList<>(counts.keySet());
        list.sort((a, b) -> counts.get(b) - counts.get(a)); 
        
        int[] result = new int[k];
        for (int i = 0; i < k; ++i)
            result[i] = list.get(i);
        return result;

        
    }
}

