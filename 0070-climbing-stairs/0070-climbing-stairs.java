class Solution {
    public int climbStairs(int n) {
        int total_way=0;
        for(int k=0;k<=n/2;k++){
            int ones = n-2*k;
            int total_moves = k+ones;
            long way_for_this_k =C(total_moves,k);
            total_way += way_for_this_k;
        }
        return total_way;
    }

    private long C(int a, int b){
        long result=1;
        for(int i=1;i<=b;i++){
            result= result*(a-b+i)/i;
        }
        return result;
    }
}