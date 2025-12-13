class Solution {
    public int fib(int n) {
        
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return fibo(n,dp);

    }
    public int fibo(int n,int dp[]){
        
       if(n<1)
       return n;
      // dp[0]=0;
       //dp[1]=1;
      int prev1=1;
      int  prev2=0;
       int curr=1;
        // if(dp[n]!=-1)
        // return dp[n];
        for(int i=2;i<=n;i++){
        curr=prev1+prev2;
        prev2=prev1;
        prev1=curr;
        }

      return curr;
    }
}