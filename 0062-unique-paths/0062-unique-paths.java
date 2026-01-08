class Solution {
    public int uniquePaths(int m, int n) {
      int dp [][] = new int[m][n];
      return dfs(m,n);
    }
    public int dfs(int row, int col){
       // if(row<0||col<0) return 0;
        int dp[][]= new int[row][col];
        if(row==0&&col==0)  return 1;
        // if(memo[row][col]!=0) return memo[row][col];
            for(int i=0;i<row;i++){
                dp[i][0]=1;
               
            }
            for(int j=0;j<col;j++){
               dp[0][j]=1;
                
            }
            for(int i=1;i<row;i++){
                for(int j=1;j<col;j++){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
       
        return dp[row-1][col-1];
    }
}