class Solution {
    Integer memo[];
    public int coinChange(int[] coins, int amount) {
        
        if(amount==0)
        return 0;

        if(amount<0)
        return -1;
        if(memo==null)
        memo=new Integer[amount+1];
        int minCoins = Integer.MAX_VALUE;

         // If already solved, return the saved answer
          if (memo[amount] != null) {
            return memo[amount];
        }
        //TRY every coin in array
        for(int coin:coins){

            int res = coinChange(coins,amount-coin);

            if(res!=-1){
                minCoins=Math.min(minCoins,res+1);
            }
        }
        memo[amount]= minCoins==Integer.MAX_VALUE?-1:minCoins;
        return memo[amount];
    }
}