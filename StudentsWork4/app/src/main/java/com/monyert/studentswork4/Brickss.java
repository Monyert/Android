package com.monyert.studentswork4;

import android.graphics.Paint;

public class Brickss {


    private boolean isVisible;
    int PosX;
    int PosY;
    int Largo_top;
    int Largo_bottom;

    public Brickss(int PosX, int PosY, int Largo_top, int Largo_bottom) {
        this.PosX = PosX;
        this.PosY = PosY;
        this.Largo_top = Largo_top;
        this.Largo_bottom = Largo_bottom;

        isVisible = true;
    }

    public Brickss() {
    }

    public void setInvisible() {
        isVisible = false;
    }

    public boolean getVisibility() {
        return isVisible;
    }
}