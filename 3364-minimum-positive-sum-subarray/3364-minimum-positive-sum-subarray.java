class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        
      
       int min_sum=Integer.MAX_VALUE; 
        for(int i=0;i<nums.size();i++){
          
          int curr_sum = 0;
          for(int j=i;j<nums.size();j++){
             curr_sum += nums.get(j);
             int length = j-i+1;

             if(length>=l&&length<=r&&curr_sum>0)
             min_sum = Math.min(curr_sum,min_sum);
          }
        }
        return min_sum==Integer.MAX_VALUE?-1:min_sum;
    }
}