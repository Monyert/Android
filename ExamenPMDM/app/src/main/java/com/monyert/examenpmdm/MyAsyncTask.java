package com.monyert.examenpmdm;

import android.os.AsyncTask;


public class MyAsyncTask extends AsyncTask<Double, Double ,Boolean> {
    FunctionActivity fun = new FunctionActivity();

    public MyAsyncTask() {
        // The constructor

    }

    @Override
    protected Boolean doInBackground(Double... params) {
        // More code

        return true;
    }

    protected void onPostExecute(Boolean is) {
        //FunctionActivity.resultado;
    }

}