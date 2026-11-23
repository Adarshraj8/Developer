class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLength=0;
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int num:set){
            // Fix 1: Only start counting if 'num' is the start of a sequence
            if(!set.contains(num-1))
            {
                int currentNum = num;
                int count=1;
                while(set.contains(currentNum+1)){
                    currentNum++;
                    count++;
                }
                  maxLength = Math.max(maxLength,count);
            }
          
        }
        return maxLength;
    }
}