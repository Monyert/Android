package com.monyert.studentswork2;

import android.os.AsyncTask;


public class MyAsyncTaskInterval extends AsyncTask<Double, Double ,Boolean> {
    IntervalPrimeNumberActivity inv = new IntervalPrimeNumberActivity();
    private String interval = ""; // The answer
    private Double start, end; // The values of the interval



    public MyAsyncTaskInterval(Double x0, Double x1) { // The constructor
        start = x0;
        end = x1;
    }

    @Override
    protected Boolean doInBackground(Double... params) {
// More code
        for (Double i = start; i < end; i++) {
            if (isPrime(i)) {
                int j;
                j = i.intValue();
                this.interval += Integer.toString(j) + " ";
            }
        } // More code if needed
        return true;
    }

    protected void onPostExecute(Boolean is) {
        IntervalPrimeNumberActivity.result.setText(interval);
        //text_result.setText(interval);
    }
    private boolean isPrime (Double n ){
        if(n==2){
            return(true);
        }
        for(int i=2;i<=(int)Math.sqrt(n)+1;i++){
            if(n%i==0){
                return(false);
            }
        }
        return(true);
    }
}