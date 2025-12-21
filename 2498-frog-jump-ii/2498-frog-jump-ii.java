class Solution {
    public int maxJump(int[] heights) {
        
        int ans = heights[1]-heights[0];

        for(int i=2;i<heights.length;i++){
           ans= Math.max(ans,heights[i]-heights[i-2]);
        }
        return ans;
    }
}