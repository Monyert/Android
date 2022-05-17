package com.monyert.studentswork;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {
    static String submenu_url;
    static String nom;

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*

        if (id == R.id.action_settings) {

            return true;
        }*/
        if (id == R.id.action_home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_buttons) {
            Intent intent = new Intent(this, MyButtonsActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.sub_web_item1) {
            Intent intent = new Intent(this, MyWebsActivity.class);

            submenu_url = getString(R.string.url_lineage);
            nom = "Lineage 2";
            startActivity(intent);
            return true;
        }
        if (id == R.id.sub_web_item2) {
            Intent intent = new Intent(this, MyWebsActivity.class);

            submenu_url = getString(R.string.url_aion);
            nom = "Aion";
            startActivity(intent);
            return true;
        }
        if (id == R.id.sub_web_item3) {
            Intent intent = new Intent(this, MyWebsActivity.class);
            nom = "Tera";
            submenu_url = getString(R.string.url_tera);

            startActivity(intent);
            return true;
        }
        if (id == R.id.action_lists) {
            Intent intent = new Intent(this, MyListActivity.class);
            startActivity(intent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

