package com.monyert.studentswork4;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class GameActivity extends MainMenu {
    public MyGameSurfaceView myGameSurfaceView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myGameSurfaceView = new MyGameSurfaceView(this);
        setContentView(myGameSurfaceView);


    }

}
