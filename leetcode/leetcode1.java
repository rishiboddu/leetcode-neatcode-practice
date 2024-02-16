/*
Leetcode #1: Two Sum (easy)
https://leetcode.com/problems/two-sum/

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.

*/



/*
Approach #1: HashMap (store values and check to see if their complement is in the previously saved values in the map)

Leetcode Stats: Runtime 2ms, Space 44.51mb
Time Complexity: O(n) - depends on size of the nums array and scales constantly 

*/


class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> vals = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (vals.containsKey(target - nums[i])){
                return new int[]{i, vals.get(target - nums[i])};
            }
            vals.put(nums[i], i);
        }
        return null;
    }
}
