/*
Leetcode #19: Remove Nth Node From End of List (medium)
https://leetcode.com/problems/remove-nth-node-from-end-of-list/

Given the head of a linked list, remove the nth node from the end of the list and return its head.
The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
Follow up: Could you do this in one pass?
*/

/*
Approach #1: using two pointer variables
Leetcode Stats: Runtime 0s, Memory 40.54mb

Runtime: O(n) (only requires one pass through the original linked list)
Memory: O(1)

Store the pointers for each node in the linked list in the array 
*/



  /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ArrayList<ListNode> nodePointers = new ArrayList<ListNode>();
        
        ListNode current = head;
        while (current != null) {
            nodePointers.add(current);
            current = current.next;
        }

        // if n == nodePointers.size() then return second element in list using the .next (to avoid array out of bounds error if only one element in list) and drop the head
        if (n == nodePointers.size()) {
            return head.next;
        }

        // remove nodePointers.size() - n 
        int nodeToModifyIndex = nodePointers.size() - n - 1;
        nodePointers.get(nodeToModifyIndex).next = nodePointers.get(nodeToModifyIndex + 1).next;
        return head;
    }






  /*
  Approach #2: Store node pointers in List
  Leetcode Stats: Runtime 0s, Memory 41.46mb
  
  Runtime: O(n) (only requires one pass through the original linked list)
  Memory: O(1)

  Use two pointers. The first pointer advances the list by n+1 steps from the beginning, while the second pointer starts from the beginning of the list. 
  Now, both pointers are exactly separated by n nodes apart. 
  We maintain this constant gap by advancing both pointers together until the first pointer arrives past the last node. 
  The second pointer will be pointing at the nnnth node counting from the last.
  We relink the next pointer of the node referenced by the second pointer to point to the node's next next node.
  */

  public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode fastNode = dummy;
      ListNode slowNode = dummy;
      
      for (int i = 1; i <= n + 1; i++) {
          fastNode = fastNode.next;
      }
    
      while (first != null) {
          fastNode = fastNode.next;
          slowNode = slowNode.next;
      }
      slowNode.next = slowNode.next.next;
      return dummy.next;
  }
  



