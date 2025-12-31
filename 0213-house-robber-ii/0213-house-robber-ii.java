class Solution {
    public int rob(int[] num) {
        
      if(num.length==1) return num[0];

      return Math.max(
        robRange(num,0,num.length-2),
        robRange(num,1,num.length-1)
      );

    }

    public int robRange(int num[],int start,int end){
      
    int dp[] = new int[end-start+1];

     dp[0] = num[start];
     if(end>start){
        dp[1] = Math.max(num[start],num[start+1]);
     }
    for(int i=2;i<dp.length;i++){
        dp[i]=Math.max(dp[i-1],num[start+i]+dp[i-2]);
    }
    return dp[dp.length-1];
    }
}