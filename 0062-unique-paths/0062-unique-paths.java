class Solution {
    public int uniquePaths(int m, int n) {
      int dp [][] = new int[m][n];
      return dfs(m-1,n-1,dp);
    }
    public int dfs(int row, int col,int memo[][]){
        if(row<0||col<0) return 0;
        if(row==0&&col==0)  return 1;
         if(memo[row][col]!=0) return memo[row][col];

        memo[row][col]= dfs(row-1,col,memo)+dfs(row,col-1,memo);
        return memo[row][col];
    }
}