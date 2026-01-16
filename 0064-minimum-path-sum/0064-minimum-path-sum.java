class Solution {
    public int minPathSum(int[][] grid) {
        int memo[][]=new int[grid.length][grid[0].length];
     return solve(grid.length-1,grid[0].length-1,grid,memo);
    }

    public int solve(int n,int m,int grid[][],int memo[][]){

        if(n<0|| m<0)return Integer.MAX_VALUE;
        
        if(n==0&&m==0)return grid[0][0];
       if(memo[n][m]!=0){
        return memo[n][m];
       }
       memo[n][m]= grid[n][m]+Math.min(
            solve(n-1,m,grid,memo),solve(n,m-1,grid,memo)
        );
        return memo[n][m];
    }
}