class Solution {
    public int totalNumbers(int[] digits) {
        
        if(digits.length<3||digits==null) return 0;

         int n = digits.length;
         Set<Integer> uniqueEvenNum = new HashSet<>();
         for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){

                    if(i!=j&&j!=k&&i!=k){

                        int hundred = digits[i];
                        int tens = digits[j];
                        int ones = digits[k];

                        if(hundred==0)continue;

                        if(ones%2==0){
                            int number = (hundred*100)+(tens*10)+(ones);
                            uniqueEvenNum.add(number);
                        }
                    }
                }
            }
         }
         return uniqueEvenNum.size();
    }
}