class Solution {
    public int numIslands(char[][] grid) {
        
      int count =0;
      int row = grid.length;
      int col = grid[0].length;

     for(int i=0;i<row;i++){
    for(int j=0;j<col;j++){
       if(grid[i][j]=='1'){
         count++;
         bfs(grid,i,j);
     }
   }
 }
  return count;
    }
   public void bfs(char grid[][],int i,int j){
       
    Queue<int[]> q  = new LinkedList<>();
    q.add(new int[]{i,j});
    grid[i][j]='0';

    int directions[][] = {{1,0},{-1,0},{0,1},{0,-1}};

    while(!q.isEmpty()){
 
       int cell[] = q.poll();
       int r = cell[0];int c =cell[1];
        
       for(int dir[]:directions){
          int nr = r+dir[0];
          int nc = c+dir[1];

         if(nr>=0&&nr<grid.length&&nc>=0&&nc<grid[0].length&&grid[nr][nc]=='1'){
             q.add(new int[]{nr,nc});
             grid[nr][nc]='0';
          }
        }  
       }
     }
}