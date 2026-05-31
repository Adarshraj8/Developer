class Solution {
    public int minElement(int[] nums) {
        
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int sum=0;
            int r = nums[i];
            while(r>0){
            sum+=r%10;
            r=r/10;
            }
           min =  Math.min(sum,min);
        }
        return min;
    }
}