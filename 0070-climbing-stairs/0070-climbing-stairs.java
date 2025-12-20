class Solution {
    public int climbStairs(int n) {
       int dp[] = new int[n+1];
       //Arrays.fill(dp,-1);
     return climbStair(n);   
    }

    public int climbStair(int n){
        //if(n<=2)return n;
      //  int dp[] = new int[n+1];
         // if(dp[n]!=-1)
         // return dp[n];
        int  prev1=1;
        int  prev2=1;
        int curr=1;
         for(int i=2;i<=n;i++){
            curr= prev2+prev1;
            prev1= prev2;
            prev2=curr;
         }
       
       return curr;
        
    }
}