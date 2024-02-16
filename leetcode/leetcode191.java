/*
Leetcode 191: Number of 1 Bits (easy)
https://leetcode.com/problems/number-of-1-bits/

Write a function that takes the binary representation of an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

Note that in some languages, such as Java, there is no unsigned integer type. 
In this case, the input will be given as a signed integer type. 
It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer -3

The input must be a binary string of length 32

*/



/* 
Approach #1: Bit Manipulation
Leetcode Stats: Runtime 0s (beats 100% of submission), Memory 40.56mb

Time Complexity: O(1)
Space Complexity: O(1)
*/

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if(n == 0){
            return 0;
        }

        int count = 0;
        // rather than going through every bit, this terminates once the 
        while(n != 0) {
            count++;
            // flip the least significant 1-bit (LSB) to 0
            // doing a bit-wise AND of n and n−1 flips the least-significant 1-bit in n to 0
            n &= (n-1);
        }
        return count;
    }




/* 
Approach #2: Bit Masking
We check each of the 32 bits of the number. If the bit is 1, we add one to the number of 1-bits.

Leetcode Stats: Runtime 1ms, Memory 39.98mb

Time Complexity: O(1)
Space Complexity: O(1)
*/

  public int hammingWeight(int n) {
      int bits = 0;
      int mask = 1;
      for (int i = 0; i < 32; i++) {
          if ((n & mask) != 0) {
              bits++;
          }
          mask <<= 1;
      }
      return bits;
  }


/* 
Approach #3: Convert to String

Leetcode Stats: Runtime 1ms, Memory 41.68mb

Time Complexity: O(1)
Space Complexity: O(1)
*/

    public int hammingWeight(int n) {
        
        String num = Integer.toBinaryString(n);
        int count = 0;
        while (num.length() > 0) {
            if(num.charAt(0) == '1') {
                count++;
            }
            num = num.substring(1);
        }
        return count;

    }


}
