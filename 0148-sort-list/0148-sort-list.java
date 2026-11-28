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
    public ListNode sortList(ListNode head) {
        
        if(head==null||head.next==null)
        return head;
       
        // 1. Find the middle and split the list
        ListNode mid = getMid(head);
        ListNode rightHalf = mid.next;
        mid.next=null;// Disconnect left and right halves
        
        //recursevely sort both half

        ListNode left = sortList(head);
        ListNode right = sortList(rightHalf);

        //mege sorted half
        return merge(left,right);
    }
    private ListNode getMid(ListNode head){

        ListNode slow=head;
        ListNode fast=head.next; // Start fast one step ahead to get first middle

        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                tail.next=l1;
                l1=l1.next;
            }
            else{
                tail.next=l2;
                l2=l2.next;
            }
            tail = tail.next;
        }
          // Attach whatever remains
        tail.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }
}