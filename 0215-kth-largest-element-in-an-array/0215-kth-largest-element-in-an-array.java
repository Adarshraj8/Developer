class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        //Arrays.sort(nums);
        int n = nums.length;
       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
       for(int num : nums){
        pq.offer(num);
       }
       for(int i=1;i<k;i++)
        pq.poll();
        return pq.peek();
    }
}