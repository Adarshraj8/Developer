class Solution {
    public int rob(int[] num) {
        
      if(num.length==1) return num[0];
      Integer memo1[]  = new Integer[num.length];
      Integer memo2[]  = new Integer[num.length];
      return Math.max(
        robRange(num,0,num.length-2,memo1),
        robRange(num,1,num.length-1,memo2)
      );

    }

    public int robRange(int num[],int start,int end,Integer memo[]){
    
    if(start>end) return 0;
   // if(memo[start]!=null) return memo[start];
    int dp[] = new int[end-start+1];
    dp[0]=num[start];
    if(end>start)
    dp[1]=Math.max(num[start],num[start+1]);
      for(int i=2;i<dp.length;i++){
        dp[i]=Math.max(dp[i-1],num[start+i]+dp[i-2]);
      }
       return dp[dp.length-1];
    }
}