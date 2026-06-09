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
//     public ListNode sortList(ListNode head) {
//         ArrayList<Integer> arr = new ArrayList<>();

//         ListNode temp = head;

//         while(temp != null){
//             arr.add(temp.val);
//             temp = temp.next;
//         }

//         Collections.sort(arr);

//         temp = head;
//         int i = 0;

//         while(temp != null){
//             temp.val = arr.get(i++);
//             temp = temp.next;
//         }

//         return head;
//     }
// }


class Solution {

    public ListNode mergeTwoSortedLinkedList(ListNode List1, ListNode List2){
        ListNode dummy = new ListNode(-1, null);

        ListNode temp = dummy;

        while(List1 != null && List2 != null){
            if(List1.val <= List2.val){
                temp.next = List1;
                List1 = List1.next;
            }
            else{
                temp.next = List2;
                List2 = List2.next;
            }
            temp = temp.next;
        }

            

            if(List1 != null){
                temp.next = List1;
                List1 = List1.next; 
            }
            else{
                temp.next = List2;
                List2 = List2.next;
            }
        

        return dummy.next;
    }

    public ListNode findMiddle(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null){              // edge case
            return head;
        }

        ListNode middle = findMiddle(head);

        // splitting the Nodes

        ListNode right = middle.next;
        middle.next = null;
        ListNode left = head;

        left = sortList(left);
        right = sortList(right);

        return mergeTwoSortedLinkedList(left,right);
        
    }
}