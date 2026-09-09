class Solution {
    public long countCommas(long n) {
      
      long total=0;
      long low=1;
      long high=9;
      int d=1;

      while(low<=n){
      long actualHigh = Math.min(n,high);

      long count = actualHigh-low+1;

      long commaPerNumber = (d-1)/3;
      total +=count*commaPerNumber;

      if(high> (Long.MAX_VALUE-9)/10) break;
      low=high+1;
      high=high*10+9;
      d++;
      }
      return total;
    }
}