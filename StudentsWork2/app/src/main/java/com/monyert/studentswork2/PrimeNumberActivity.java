package com.monyert.studentswork2;

import android.app.Notification;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Display;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;

public class PrimeNumberActivity extends MainMenu implements NavigationView.OnNavigationItemSelectedListener {


    static TextView resultField;
    EditText parser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime_number);
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

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout_prime);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_prime);
        navigationView.setNavigationItemSelectedListener(this);

        resultField = findViewById(R.id.text_resultado_numero_primo);
        parser = findViewById(R.id.text_input);

    }

    public void primeCheckWithAsyncTask(View view) {

        double parameter = Double.parseDouble(parser.getText().toString());
        MyAsyncTaskPrime mAsyncTask = new MyAsyncTaskPrime();
        mAsyncTask.execute(parameter);
        //Toast per comprovar que realment esta fent el parse del numero escrit
        //Toast.makeText(this,  parser.getText().toString(), Toast.LENGTH_LONG).show();
    }


    public class MyAsyncTaskPrime extends AsyncTask<Double, Integer, Boolean> {
        private int ntimes = 4, interval = 25;
        protected void onPreExecute() {

            PrimeNumberActivity.resultField.setText("Calculating");
        }

        protected Boolean doInBackground(Double... n) {
            // Calling to the isPrime(…) method
          return isPrime(n[0]);
        }

        protected void onProgressUpdate(Integer... progress) {
            PrimeNumberActivity.resultField.setText((progress[0] * interval) + "% completed");
        }

        protected void onPostExecute(Boolean result) {

            if (result) {
                PrimeNumberActivity.resultField.setText("Yes");
            }else {
                PrimeNumberActivity.resultField.setText("No");

            }
        }

        private boolean isPrime(Double n) {
            //n multiplo de 2?...
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
    }

