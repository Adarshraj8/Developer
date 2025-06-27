class Solution {
    public void nextPermutation(int[] nums) {

        int i = nums.length-2;

         while(i>=0&&nums[i]>=nums[i+1]){
          
                i--;
            
         }
         
         if(i>=0){
             int j = nums.length-1;
            while(nums[i]>=nums[j]){
                j--;
            }
           swap(nums,i,j);
         
         }
           reverse(nums,i+1,nums.length-1);
    }

    public void swap(int nums[],int i,int j){
        int temp = nums[j];
        nums[j]=nums[i];
        nums[i]=temp;
    }

    public void reverse(int nums[],int left,int right){

          while(left<right){
            swap(nums,left++,right--);
          }
    }
}