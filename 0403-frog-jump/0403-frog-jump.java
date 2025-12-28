class Solution {

    public boolean canCross(int[] stones) {
     int n = stones.length;
      //Set<Integer> jump = new HashMap<>();
      Map<Integer, Set<Integer>> dp = new HashMap<>();

      for(int s:stones){
        dp.put(s,new HashSet<>());
      }      

      dp.get(0).add(0);
      for(int s :stones){
         for(int jump: dp.get(s)){
            for(int step=jump-1;step<=jump+1;step++){
                if(step>0&&dp.containsKey(step+s)){
                    dp.get(step+s).add(step);
                }
            }
         }
      }
      return !dp.get(stones[n-1]).isEmpty();
    }
}