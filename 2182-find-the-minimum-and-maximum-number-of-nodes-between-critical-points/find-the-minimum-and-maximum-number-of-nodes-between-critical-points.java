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
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }
        
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;

        int index = 1;

        int firstCP = -1;
        int previousCP = -1;
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = -1;

        while(next != null){
            
            if(curr.val < prev.val && curr.val < next.val || 
               curr.val > prev.val && curr.val > next.val){

                if(firstCP == -1){
                    firstCP = index;
                    previousCP = index;
                }
                else{
                    minDistance = Math.min(minDistance, index - previousCP);
                    maxDistance = index - firstCP;
                    previousCP = index;
                }
                
            }

            prev = curr;
            curr = next;
            next = next.next;
            index++;
        }

        if (minDistance == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        return new int[]{minDistance, maxDistance};

    }
}