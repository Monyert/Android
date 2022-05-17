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

import java.util.ArrayList;
import java.util.List;

public class FactorizeNumberActivity extends MainMenu implements NavigationView.OnNavigationItemSelectedListener {

    EditText parser_factorize;
    static TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorize_number);
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

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout_factorize);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_factorize);
        navigationView.setNavigationItemSelectedListener(this);

        parser_factorize = findViewById(R.id.factorize_value);
        res = findViewById(R.id.factorize_res);
    }

    public void Factorize(View view) {
        Double parameter = Double.parseDouble(parser_factorize.getText().toString());

        MyAsyncTaskFactorize mAsyncTask = new MyAsyncTaskFactorize();
        mAsyncTask.execute(parameter);

    }


    public class MyAsyncTaskFactorize extends AsyncTask<Double, Double ,Boolean> {
        String interval = "";
        @Override
        protected Boolean doInBackground(Double... params) {

            while (params[0]%2==0)
            {
                interval +=(2 + " ");
                params[0] /= 2;
            }

            for (int i = 3; i <= Math.sqrt(params[0]); i+= 2)
            {
                // While i divides n, print i and divide n
                while (params[0]%i == 0)
                {
                    interval +=i + " ";
                    params[0] /= i;
                }
            }

            if (params[0] > 2)
                interval += params[0].intValue();


            return true;
        }

        protected void onPostExecute(Boolean is) {
            FactorizeNumberActivity.res.setText(interval);


        }

    }

}
