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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode dummyA = headA;
        ListNode dummyB = headB;
        
        int sizeA = 0;
        int sizeB = 0;

        while(dummyA != null){
            sizeA++;
            dummyA = dummyA.next;
        }

        while(dummyB != null){
            sizeB++;
            dummyB = dummyB.next;
        }

        int diff = Math.abs(sizeA-sizeB);

        if(sizeA > sizeB){
            for(int i = 0; i < diff; i++){
                headA = headA.next;
            }
        }
        else{
            for(int i = 0; i < diff; i++){
                headB = headB.next;
            }
        }

        while(headA != null && headB != null){
            if(headA == headB){
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}