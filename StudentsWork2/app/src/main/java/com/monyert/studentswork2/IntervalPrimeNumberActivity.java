package com.monyert.studentswork2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IntervalPrimeNumberActivity extends MainMenu implements NavigationView.OnNavigationItemSelectedListener {

    EditText from;
    EditText to;
    static TextView result;
    MyAsyncTaskInterval interval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interval_prime_number);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout_interval);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_interval);
        navigationView.setNavigationItemSelectedListener(this);

        from = findViewById(R.id.interval_number1);
        to = findViewById(R.id.interval_number2);
        result = findViewById(R.id.text_resultado_interval);
    }

    public void findPrimeNumbers(View view) {

        //String text = result.getText().toString();
        Double interval1 = Double.parseDouble(from.getText().toString());
        Double interval2 = Double.parseDouble(to.getText().toString());

        //Toast.makeText(this,  from.getText().toString(), Toast.LENGTH_SHORT).show();
        //Toast.makeText(this,  to.getText().toString(), Toast.LENGTH_LONG).show();
        MyAsyncTaskInterval interval = new MyAsyncTaskInterval(interval1, interval2);
        interval.execute();
    }

/*  Si queremos el Async dentro de la clase descomentar.
    public class MyAsyncTaskInterval extends AsyncTask<Double, Double ,Boolean> {
            String interval = "";
        @Override
        protected Boolean doInBackground(Double... params) {

            for (Double i = params[0]; i < params[1]; i++) {
                if (isPrime(i)) {
                    interval += Double.toString(i) + " ";
                }
            }
            return null;
        }

        protected void onPostExecute(Boolean is) {
            IntervalPrimeNumberActivity.result.setText(interval);
        }
        private boolean isPrime (Double n ){
            if(n==2){ //for case num=2, function returns true. detailed explanation underneath
                return(true);
            }
            for(int i=2;i<=(int)Math.sqrt(n)+1;i++){ //loops through 2 to sqrt(num). All you need to check- efficient
                if(n%i==0){ //if a divisor is found, its not prime. returns false
                    return(false);
                }
            }
            return(true); //if all cases don't divide num, it is prime.
        }
    }
    */

}
