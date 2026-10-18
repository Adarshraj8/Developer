class Solution {
    public boolean exist(char[][] board, String word) {
        
        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(board,word,i,j,0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char board[][],String word,int r,int c,int idx){
        if(word.length()==idx) return true;//pura word mil gya iska matlab
         //boundary mistmatch ya alrady visited
         if(r<0||c<0||r>=board.length||c>=board[0].length||board[r][c]!=word.charAt(idx))
         return false;
        char temp = board[r][c];
        board[r][c]='#';//visited mark

        boolean found=dfs(board,word,r+1,c,idx+1)
                     ||dfs(board,word,r-1,c,idx+1)
                     ||dfs(board,word,r,c+1,idx+1)
                     ||dfs(board,word,r,c-1,idx+1);

                     board[r][c]= temp;//baacktrack unmark

                     return found;
    }
}