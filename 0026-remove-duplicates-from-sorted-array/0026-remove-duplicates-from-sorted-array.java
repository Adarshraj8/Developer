class Solution {
    public int removeDuplicates(int[] nums) {
        
        int left =0;
        int right=1;
        int count=0;
    
        while(left<right&&right<nums.length){

            if(nums[left]!=nums[right]){
                
               count++;
               left++;
               nums[left]=nums[right];
            }
            right++;
           
            
        }
        return count+1;
    }
}