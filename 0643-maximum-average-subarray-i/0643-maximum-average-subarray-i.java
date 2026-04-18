class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxSum = Double.NEGATIVE_INFINITY;
        int right=0;
        int left=0;
        double sum=0;
        while(right<nums.length){
           
              sum+=nums[right];
             //shrink if window >k
               if(right-left+1>k){
                 sum-=nums[left];
                 left++;
               }
             if(right-left+1==k){
            maxSum=Math.max(maxSum,sum);
             }
             right++;
        }
        return maxSum/k;
    }
}