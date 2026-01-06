class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
      
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
          int memo[][] = new int[m][n];
       return dfs(m-1,n-1,obstacleGrid,memo);
    }
    public int dfs(int row,int  col,int obstacleGrid[][],int memo[][]){
        if(row<0 ||col<0)return 0;
         if(obstacleGrid[row][col]==1) return 0;
        if(row==0&&col==0) return 1;
         if(memo[row][col]!=0) return memo[row][col];
        memo[row][col]= dfs(row-1,col,obstacleGrid,memo)+dfs(row,col-1,obstacleGrid,memo);
        return memo[row][col];
    }
}