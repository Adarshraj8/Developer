class Solution {
    public int minPathSum(int[][] grid) {
      int n = grid.length;
      int m=grid[0].length;
      if(n<0||m<0) return Integer.MAX_VALUE;

      int dp[] = new int[m];
      dp[0]=grid[0][0];
      for(int j=1;j<m;j++){
       dp[j]=dp[j-1]+grid[0][j];
      }

      

       for(int i=1;i<n;i++){
        dp[0]+=grid[i][0];
        for(int j=1;j<m;j++){
            dp[j] = grid[i][j]+Math.min(dp[j],dp[j-1]);
        }
       }
       return dp[m-1];
    }
}