class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();

        backtrack(nums,0,new ArrayList<>(),list);
        return list;
    }

     private void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
     
     if(index==nums.length){
        result.add(new ArrayList<>(current));
        return;
     }

     current.add(nums[index]);
     backtrack(nums,index+1,current,result);
     current.remove(current.size()-1);
     
     backtrack(nums,index+1,current,result);
     }
}