class Solution {

      Integer [][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
   int n = triangle.size();
    memo = new Integer[n][n];
    return solve(0,0,triangle);

    }

    public int solve(int row, int col,List<List<Integer>> triangle){

        if(triangle.size()-1==row){
            return triangle.get(row).get(col);
        }
        if(memo[row][col]!=null){
            return memo[row][col];
        }

       memo[row][col]= triangle.get(row).get(col)+Math.min(solve(row+1,col,triangle),solve(row+1,col+1,triangle));
       return memo[row][col];
    }
}