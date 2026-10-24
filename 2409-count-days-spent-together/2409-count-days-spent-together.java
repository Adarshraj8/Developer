class Solution {
     private final int [] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        
       

        int startA = convertYearToDay(arriveAlice);
        int endA = convertYearToDay(leaveAlice);
        int startB = convertYearToDay(arriveBob);
        int endB = convertYearToDay(leaveBob);

        //latest arrival and earliest departure
        int latestArrival = Math.max(startA,startB);
        int earliestDeparture = Math.min(endA,endB);

        if(latestArrival<=earliestDeparture){
          return earliestDeparture-latestArrival+1;
        }
        else
        return 0;
    }

    private int convertYearToDay(String date){
        //substring(0,2) give month and(3,5) give day
        int month = Integer.parseInt(date.substring(0,2));
        int day = Integer.parseInt(date.substring(3,5));
        
        int dayCount=0;
        //sum of all day completed in previous months
        for(int i=0;i<month-1;i++){
         dayCount+=daysInMonths[i];
        }
        //add the day pass in current month
        dayCount+=day;
        return dayCount;
    }
}