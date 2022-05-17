package com.monyert.studentswork3.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.monyert.studentswork3.R;

public class MainMenu extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_poblacions) {
            Intent intent = new Intent(this, PoblacionsActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_gestio_poblacions) {
            Intent intent = new Intent(this, GestioPoblacionsActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_gestio_tendes) {
            Intent intent = new Intent(this, GestioTendesActivity.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }
}
