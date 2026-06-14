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
    public int pairSum(ListNode head) {
        
        ListNode current= head;
        int maxSum=0;
        ArrayList<Integer> list = sizeList(head);
        int n = list.size();
        for(int i=0;i<n/2;i++){
            int twinSum= list.get(i)+list.get(n-i-1);
            maxSum = Math.max(maxSum,twinSum);
        }
        
        return maxSum;

     }

    public ArrayList<Integer> sizeList(ListNode head){
    ArrayList<Integer> list = new ArrayList<>();
      ListNode curr=head;
      int count=0;
      while(curr!=null){
        list.add(curr.val);
        count++;
        curr=curr.next;

     }
      return list;
    }
}