class Solution {

    //  Integer [][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
   int n = triangle.size();
    //memo = new Integer[n][n];
    return solve(0,0,triangle);

    }

    public int solve(int row, int col,List<List<Integer>> triangle){

       
        int dp[] = new int[triangle.size()];
          int n = triangle.size();
         for(int j=0;j<triangle.get(n-1).size();j++){
            dp[j]=triangle.get(n-1).get(j);
         }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
         dp[j]= triangle.get(i).get(j)+Math.min(dp[j],dp[j+1]);
        }
        }

       
       return dp[0];
    }
}