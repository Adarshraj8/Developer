class Solution {
    public int reverseDegree(String s) {
        
        int n = s.length();
        int sum=0;
        for(int i=0;i<n;i++){
        int asc= 26- (s.charAt(i)-'a');
    // Change idx to be the 1-based index of the character in the string
        int idx = i+1;
         
         sum+=asc*idx;
        }
        return sum;
    }
}