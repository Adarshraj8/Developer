class Solution {
    public void rotate(int[] nums, int k) {
        
        int arr[] = new int[nums.length];
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            arr[(i+k)%n]=nums[i];
        }
        
        for(int i=0;i<nums.length;i++){
            nums[i]=arr[i];
        }
    }
}