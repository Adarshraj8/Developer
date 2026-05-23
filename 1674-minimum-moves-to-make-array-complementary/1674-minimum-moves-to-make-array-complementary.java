class Solution {
    public int minMoves(int[] nums, int limit) {
     
     int n = nums.length;
     int diff[] = new int[2*limit+2];

     for(int i=0;i<n/2;i++){
        int a = nums[i];
        int b = nums[n-1-i];

        int lo = Math.min(a,b);
        int hi = Math.max(a,b);

        diff[lo+1]-=1;
        diff[hi+limit+1]+=1;

        diff[a+b]-=1;
        diff[a+b+1]+=1; 
     }
     int ans = n;
     int current=n;
     for(int T=2;T<=2*limit;T++){
        current+=diff[T];
       ans =  Math.min(ans,current);
     }
     return ans;
    }
}