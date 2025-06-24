class Solution {
    public int removeDuplicates(int[] nums) {
      
      if(nums.length==0)return 0;
             int i=0;// pointer to place next unique element
            for(int j=1;j<nums.length;j++){
                if(nums[i]!=nums[j]){
                    i++;// move i to next position
                    nums[i]=nums[j];// copy unique element
               }
              }
                return i+1;// length of unique elements
        }
    
    }
