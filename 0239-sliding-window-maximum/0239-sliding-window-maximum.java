class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        
        int arr[] = new int[n-k+1];
        Deque<Integer> dq = new LinkedList<>();
        int idx=0;
        for(int i=0;i<n;i++){
            //remove index outside current index
         while(!dq.isEmpty()&&dq.peekFirst()<=i-k){
            dq.pollFirst();
         }

         //remove smaller element from back
         while(!dq.isEmpty()&&nums[dq.peekLast()]<nums[i]){
            dq.pollLast();
         }
          //add current index
         dq.offerLast(i);


         if(i>=k-1){
            arr[idx++]=nums[dq.peekFirst()];
         }
        }
         return arr;
    }
}