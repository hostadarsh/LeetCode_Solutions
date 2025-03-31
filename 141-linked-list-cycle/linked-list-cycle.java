/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


// public class Solution {
//     public boolean hasCycle(ListNode head) {

//         Map<ListNode,Integer> nodeMap = new HashMap<>();
//         ListNode temp = head;

//         while(temp != null){

//             if(nodeMap.containsKey(temp)){
//                 return true;
//             }

//             nodeMap.put(temp,1);
//             temp = temp.next;

//         }

//         return false;


        
//     }
// }


public class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }       
        return false;
    }
}