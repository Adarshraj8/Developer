class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        HashSet<Integer> seen = new HashSet<>();
         for(int k :nums){
             if(seen.contains(k)){
                return true;
             }
             seen.add(k);
         }
         return false;
        
    }
}