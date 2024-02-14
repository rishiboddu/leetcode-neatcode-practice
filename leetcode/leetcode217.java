/* 
https://leetcode.com/problems/contains-duplicate/description/
leetcode 217: contains duplicates (easy)
*/

import java.util.Map;
import java.util.HashMap;

class Solution {

    /* 
      Approach #1: HashMap (faster than a hashset; because values are associated with a unique key. 
          HashSet is slower than HashMap because the member object is used for calculating hashcode value, 
          which can be same for two objects)
        For a self-balancing Binary Search Tree (TreeSet or TreeMap in Java), search() and insert() are both O(log⁡n)O(\log n)O(logn) time. 
        For a Hash Table (HashSet or HashMap in Java), search() and insert() are both O(1)O(1)O(1) on average
      HashTable allows for 0(1) access by key and requires only one traversal of the elements, checking for duplicates as we go

      Time complexity: O(n)O(n)O(n).
        We do search() and insert() for nnn times and each operation takes constant time.
        
      Space complexity: O(n)O(n)O(n).
        The space used by a hash table is linear with the number of elements in it.

      Leetcode Stats: Runtime 12ms, 60.67 memory, 0(1)
    */
  
    public boolean containsDuplicate(int[] nums) {        
        Map<Integer, Integer> counts = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(counts.containsKey(nums[i])){
                return true;
            }
            counts.put(nums[i], 1);
        }
        return false;
        
    }



  /* Approach #2: Sorting (If there are any duplicate integers, they will be consecutive after sorting.)
      Depending on sorting algorithm, the time and space complexity will vary. 

      Time complexity: O(nlog⁡n)O(n \log n)O(nlogn).
        Sorting is O(nlog⁡n)O(n \log n)O(nlogn) and the sweeping is O(n)O(n)O(n). The entire algorithm is dominated by the sorting step, which is O(nlog⁡n)O(n \log n)O(nlogn).
      
      Space complexity: O(1)O(1)O(1).
        Space depends on the sorting implementation which, usually, costs O(1)O(1)O(1) auxiliary space if heapsort is used.


      Flaws:
      - May be faster than approach #1 for smaller inputs but generally O(nlogn) algorithms dont scale well
      - worst case scenario: the duplicate items are the last items we check when we sweep the sorted array (ex: sorted in descending order, duplicates are smallest value items)
      - editing given array in some scenarios may not be allowed, so you may have to make a copy of the given array which takes additional memory and time
  */
    public boolean containsDuplicate(int[] nums) {        
        numsCopy = Arrays.copy(nums)
        Arrays.sort(numsCopy); // this is the given sorting method (timsort) but one could possibly implement a different sorting method to speed up the process (ex: quicksort)
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }



  // There are other implementations, some of which are even less efficient with O(n^2) runtime, so I've chosen to not include them in this page
  
}
