class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

       int m = arr1.length;
       int n = arr2.length;
       int distance_count=0;
       for(int i=0;i<m;i++){
          boolean is_valid=true;
         for(int j=0;j<n;j++){
            if(Math.abs(arr1[i]-arr2[j])<=d){
                is_valid=false;
             break;
            }
         }

         if(is_valid==true) distance_count++;
       }  
       return distance_count; 
    }
}