class Solution {
    public int climbStairs(int n) {
       int dp[] = new int[n+1];
       Arrays.fill(dp,-1);
     return climbStair(n,dp);   
    }

    public int climbStair(int n,int dp[]){
        if(n<=2)return n;
          if(dp[n]!=-1)
          return dp[n];
       dp[n]= climbStair(n-1,dp)+climbStair(n-2,dp);
       return dp[n];
        
    }
}