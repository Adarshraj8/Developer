class Solution {
    public int reverseDegree(String s) {
        
        int n = s.length();
        int sum=0;
        for(int i=0;i<n;i++){
        int asc= 26- (s.charAt(i)-'a');
        int idx = i+1;
         
         sum+=asc*idx;
        }
        return sum;
    }
}