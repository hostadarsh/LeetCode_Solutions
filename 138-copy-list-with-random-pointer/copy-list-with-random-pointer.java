/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        Node temp = head;
        Node dummy = new Node(-1);
        Node itr= dummy;

        while(temp != null){
            Node node = new Node(temp.val);
            map.put(temp,node);
            itr.next = node;
            itr = itr.next;
            temp = temp.next;
        }

        itr.next = null;

        temp = head;

        while(temp != null){
            Node rand = temp.random;
            Node node = map.get(temp);
            node.random = rand != null ? map.get(rand):null;
            temp = temp.next;

        }
        return dummy.next;
    }
}