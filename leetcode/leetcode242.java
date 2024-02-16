/* 

Leetcode 242: Valid Anagrams (easy) 
https://leetcode.com/problems/valid-anagram/

Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
s and t consist of lowercase English letters

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.

*/




/*
  Approach #1: Sorting
  Once the two strings are turned into Char arrays and sorted, we can easily check if theyre equal to one another because anagrams have the same letters in different orders
    time complexity: O(nlogn) - this can depend on the sorting algorithm you use; bubble sort and other inefficient algorithms will take O(n^2) whereas merge sort or quicksort can have faster times
    space complexity: O(1) - this can also change depending on the implementation of the sorting algorithm; for example a sorting algorithm that makes copies of array subsections or uses recursion will use more space compared to an iterative algorithm
  Leetcode stats: Runtime: 4s, Memory: 44.42
*/

import java.util.HashMap;

class Solution {
     public boolean isAnagram(String s, String t) {

         // base case: if the length of the two strings are unequal, false

         if (s.length() != t.length()) {
             return false;
         }


        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        // using the Arrays class built in sorting algorithm but this section can be replaced with your own algorithm
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        
        return Arrays.equals(sChars, tChars);
    }
}





/*
  Approach #2: HashMap (store the counts of all the characters in s and for every character you find in t, decrement by one so that by the end if theres any character in the hashmap with a frequency that isn't 0, then we know they're not anagrams)

  time complexity: O(n) It iterates over each character once to count the frequencies and then compares the frequencies in the map, making it an efficient solution for the problem.
  space complexity: O(1)

  Leetcode stats: Runtime: 13ms, Space: 44.92
  
*/
     public boolean isAnagram(String s, String t) {

         // base case: if the length of the two strings are unequal, false

         if (s.length() != t.length()) {
             return false;
         }

       
        HashMap<Character, Integer> counts = new HashMap<Character, Integer>();
 
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) - 1);
        }
        
        for (int x : counts.values()) {
            if (x != 0) {
                return false;
            }
        }
        return true;
    
      
    }
}
