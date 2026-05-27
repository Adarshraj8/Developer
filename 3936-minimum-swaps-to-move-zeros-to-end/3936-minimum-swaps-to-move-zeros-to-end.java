class Solution {
    public int minimumSwaps(int[] nums) {
     
     int left=0;
     int right=nums.length-1;
     int swap=0;
     while(left<right){

        if(nums[left]!=0)
        left+=1;
        else if(nums[right]==0)
        right-=1;
        else
        {
            int temp = nums[left];
            nums[left++]=nums[right];
            nums[right--]=temp;
            swap++;
        }
     } 
        
     return swap;
    }
    }