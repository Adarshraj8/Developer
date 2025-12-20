class Solution {
    public int climbStairs(int n) {
       int dp[] = new int[n+1];
       //Arrays.fill(dp,-1);
     return climbStair(n);   
    }

    public int climbStair(int n){
        //if(n<=2)return n;
        int dp[] = new int[n+1];
         // if(dp[n]!=-1)
         // return dp[n];
         dp[0]=1;
         dp[1]=1;
       
         for(int i=2;i<=n;i++){
            dp[i]= dp[i-1]+dp[i-2];
         }
       
       return dp[n];
        
    }
}