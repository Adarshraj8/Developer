class Solution {
    public int minOperations(int[] nums, int x) {
        

      int total_sum=0;
      for(int num:nums){
        total_sum+=num;
      }
       
       int target = total_sum-x;
       if(target==0) return  nums.length;
       if(target<0) return -1;

        int curr_sum=0;
        int maxlength=-1;
        int left=0;
        for(int right=0;right<nums.length;right++){

            curr_sum+=nums[right];
            while(curr_sum>target){
                
                curr_sum-=nums[left];
                 left++;
            }
            if(curr_sum==target)
                maxlength=Math.max(maxlength,right-left+1);
        }
            return maxlength==-1?-1:nums.length-maxlength;
    }
}