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
        
        ListNode prev=head;
        ListNode curr = head.next;

        int index=1;
        int firstCriticalIdx=-1;
        int prevCriticalIdx=-1;
        int minDistance = Integer.MAX_VALUE;
        while(curr.next!=null){

            boolean isMax = curr.val>prev.val&&curr.val>curr.next.val;
            boolean isMin = curr.val<prev.val&&curr.val<curr.next.val;
 
            if(isMax||isMin){
                if(firstCriticalIdx==-1)
                firstCriticalIdx=index;
                else
                minDistance = Math.min(minDistance,index-prevCriticalIdx);
                prevCriticalIdx=index;
            }

            prev=curr;
            curr=curr.next;
            index++;
        }

        if(firstCriticalIdx==-1||firstCriticalIdx==prevCriticalIdx)
        return new int[]{-1,-1};

        int maxDistance = prevCriticalIdx-firstCriticalIdx;
        return new int[]{minDistance,maxDistance};
    }
}