/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

//         while(headB != null){
//             ListNode temp = headA;
//             while(temp != null){
//                 if(temp == headB){
//                     return headB;
//                 }
//                 temp = temp.next;
//             }
//             headB = headB.next;
//         }

//         return null;
        
//     }
// }

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        HashSet<ListNode> hs = new HashSet<>();

        while(headA != null){
            hs.add(headA);
            headA = headA.next;
        }

        while(headB != null){
            if(hs.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }

        return null;
        
    }
}