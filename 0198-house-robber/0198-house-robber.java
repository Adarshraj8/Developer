class Solution {
    public int rob(int[] nums) {
        int prev1=0;
        int prev2=0;

        for(int k : nums){
            int curr = Math.max(prev1,k+prev2);
            
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}