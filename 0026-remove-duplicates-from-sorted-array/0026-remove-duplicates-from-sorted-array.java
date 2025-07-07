class Solution {
    public int removeDuplicates(int[] nums) {
        int left =0;
        int right =1;
        int count=0;
        while(right<nums.length){
            if(nums[left]!=nums[right]){
                nums[++left]=nums[right];
                count++;
            }
            right++;
        }
        return count+1;
    }
}