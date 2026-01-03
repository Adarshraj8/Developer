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
    if(memo[start]!=null) return memo[start];
    

    memo[start]= Math.max(robRange(num,start+1,end, memo),
                     num[start]+robRange(num,start+2,end,memo));
    return memo[start];
    }
}