class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boats=0;
        int left =0;
        int right=people.length-1;
        Arrays.sort(people);
        while(left<=right){
              
             
             int sum = people[left]+people[right];
           
             if(sum<=limit){
                boats++;
                left++;
                right--;
             }
             else if(sum<limit){
                left++;
                boats++;
             }
             else {
                right--;
                boats++;
             }
            
        }
        return boats;
    }
}