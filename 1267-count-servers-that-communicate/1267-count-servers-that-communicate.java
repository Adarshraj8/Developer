class Solution {
    public int countServers(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int row_count[] = new int[m];
        int col_count[] = new int[n];
          //Step 1: Count servers in each row and column
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    row_count[i]+=1;
                    col_count[j]+=1;
                }
            }
        }

         // Step 2: Count servers that can communicate

         int ans=0;
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    if(row_count[i]>1 || col_count[j]>1){
                        ans+=1;
                    }
                }
            }
         }
         return ans;
    }
}