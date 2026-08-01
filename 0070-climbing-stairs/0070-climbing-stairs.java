class Solution {
    public int climbStairs(int n) {
        
        int memo[] = new int[n+1];
        Arrays.fill(memo,-1);
        return findWays(memo,n);

    }

  private int findWays(int memo[],int n){
    if(n<=2)
    return n;

    if(memo[n]!=-1)
    return memo[n];

    memo[n]= findWays(memo,n-1)+findWays(memo,n-2);
    return memo[n];
  }
}