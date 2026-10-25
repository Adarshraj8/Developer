class Solution {
    public int closedIsland(int[][] grid) {

     int row = grid.length;
     int col = grid[0].length;

     int closedIslandCount=0;

     //scan and sink border island
     //scan the top and bottom borders(row)
     for(int j=0;j<col;j++){
        if(grid[0][j]==0)
        sinkIslandDFS(grid,0,j);//top edge
        if(grid[row-1][j]==0)
        sinkIslandDFS(grid,row-1,j);
        }

        //scan the left and right border(col)

        for(int i=0;i<row;i++){
            if(grid[i][0]==0)
            sinkIslandDFS(grid,i,0);//left edge
            if(grid[i][col-1]==0)
            sinkIslandDFS(grid,i,col-1);//right edge
        }   

        //scan the interiror and count
        for(int i=1;i<row-1;i++){
            for(int j=1;j<col-1;j++){
               if(grid[i][j]==0){
                 closedIslandCount++; // Step 2: Increment count
                 sinkIslandDFS(grid,i,j); // Step 3: Sink it so we don't duplicate count
               }
            }
        }
        return closedIslandCount;
    }

    private  void sinkIslandDFS(int grid[][],int r,int c){

       int row = grid.length;
       int col = grid[0].length;

       //base case stop if out of grid or its alrady 1
       if(r<0||r>=row||c<0||c>=col|| grid[r][c]==1)
       return;

       //turn the current land cell into water

       grid[r][c]=1;

       //walk 4 directionally to sink the rest
       sinkIslandDFS(grid,r-1,c);//up
       sinkIslandDFS(grid,r+1,c);//down
       sinkIslandDFS(grid,r,c-1);//left
       sinkIslandDFS(grid,r,c+1);//right
    }
}