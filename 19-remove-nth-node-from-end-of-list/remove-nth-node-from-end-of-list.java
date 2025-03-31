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
// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {

//          ListNode temp = head;
//          int count= 0;

//          while(temp != null){       // find count
//             count++;
//             temp = temp.next;
//          }

//          if(count == n){
//             ListNode newHead = head.next;
//             head = null;
//             return newHead;
//          }

//          int pos = count - n;
//          temp = head;

//          while(temp != null){
//             pos--;
//             if(pos == 0){
//                 break;
//             }
//             temp = temp.next;
//          }


//          ListNode delNode = temp.next;
//          temp.next = temp.next.next;
//          delNode = null;
//          return head;         
//     }
// }


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode slow = head;
        ListNode fast = head;
        
        while(n != 0){
            fast = fast.next;
            n--;
        }

        if(fast == null){
            head = head.next;
            return head;
        }

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        ListNode delNode = slow.next;
        slow.next = slow.next.next;
        delNode = null;
        return head;




                
    }
}