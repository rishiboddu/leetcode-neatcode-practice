/*
Leetcode 49: Group Anagrams (medium)
https://leetcode.com/problems/group-anagrams

Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

*/


/*
Approach #1: HashMap
Maintain a map where each key K is a sorted string, and each value is the list of strings 
from the initial input that when sorted, are equal to K

Leetcode Stats: Runtime 7ms, Memory 47.72mb

Time Complexity: O(NKlog⁡K), where N is the length of strs, and K is the maximum length of a string in strs. 
The outer loop has complexity O(N) as we iterate through each string. Then, we sort each string in O(Klog⁡K) time.

Space Complexity: O(NK), the total information content stored our hashmap

*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> anagrams = new HashMap<String, List<String>>();

        for (String str : strs) {
            // Convert each element of strs from a string into a char array, sort the character alphabetically, and convert it back into a string
            char[] s = str.toCharArray();
            Arrays.sort(s);

            // If the newly sorted string hasnt been found in the hashmap yet, insert a new key value with an empty String ArrayList as the corresponding value and add the original word/element from strs as the first element
            // If it has been found before, add the original word/element from strs to the existing arraylist associated with that key value
            List<String> newInput = anagrams.getOrDefault(new String(s), new ArrayList<>());
            newInput.add(str); 
            anagrams.put(new String(s), newInput);
        }

        return new ArrayList(anagrams.values());
    }
}
