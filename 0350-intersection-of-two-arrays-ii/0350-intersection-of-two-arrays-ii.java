class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num : nums1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        //find the commmon element in nums2
        for(int num2:nums2){
            if(map.containsKey(num2)&&map.get(num2)>0){
                list.add(num2);
                map.put(num2,map.get(num2)-1);
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}