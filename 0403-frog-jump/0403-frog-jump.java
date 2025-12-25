class Solution {
    public boolean canCross(int[] stones) {
        

        Map<Integer,Set<Integer>> map = new HashMap<>();

        for(int s : stones){
            map.put(s,new HashSet<>());
       }
         map.get(0).add(0);
       for(int s : stones){
        for(int k:map.get(s)){
         for(int steps=k-1;steps<=k+1;steps++){
            if(steps>0 && map.containsKey(steps+s)){
                map.get(steps+s).add(steps);
            }
         }
        }
       }
       return !map.get(stones[stones.length-1]).isEmpty();
    }
}