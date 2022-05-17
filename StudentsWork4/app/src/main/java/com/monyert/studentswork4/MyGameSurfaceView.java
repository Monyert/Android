package com.monyert.studentswork4;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

public class MyGameSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private MyAnimationThread animThread = null;
    private Bitmap barra;
    private Bitmap fondo;

    private SoundPlayer sound;

    //Variables Resolucion de Pantalla
    private int width = getWidth();
    private int height = getHeight();

    // Variables Pelota
    int radi = 25; //Radio de la Pelota
    public int x;
    public int y; // Posiciones de la Pelota x -> y ^

    //Variables de Rebote
    private int ReboteX = 10;
    private int ReboteY = 10;

    //Variables Barra
    private float xPaleta = 100;
    private float yPaleta = 1000;
    private float Largo_Paleta = 200;
    private float Altura_paleta = 30;
    private float ultimaXPaleta, ultimaYPaleta;

    //Instancias
    Paint rect = new Paint();
    Paint paint = new Paint();
    Paint circle = new Paint();

    int fila_1_dalt = 100;
    int fila_1_baix = 100;
    int PuntX = 30;
    int PuntY = 30;

    Brick[] bricks = new Brick[200];
    int numBricks = 0;

    Brickss brick5 = new Brickss(PuntX + 560, PuntY, PuntX + 560 + fila_1_dalt, PuntY + fila_1_baix);
    Brickss brick_f2 = new Brickss(PuntX + 200, PuntY + 250, PuntX + 200 + fila_1_dalt, PuntY + 250 + fila_1_baix);
    Brickss brick2_f2 = new Brickss(PuntX + 350, PuntY + 250, PuntX + 350 + fila_1_dalt, PuntY + 250 + fila_1_baix);
    Brickss brick4 = new Brickss(PuntX + 420, PuntY, PuntX + 420 + fila_1_dalt, PuntY + fila_1_baix);
    Brickss brick3 = new Brickss(PuntX + 280, PuntY, PuntX + 280 + fila_1_dalt, PuntY + fila_1_baix);

    // The constructor
    public MyGameSurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);

        for (int column = 0; column < 7; column++) {
            for (int row = 0; row < 3; row++) {
                bricks[numBricks] = new Brick(row, column, 103, 50);
                numBricks++;
            }
        }

        sound = new SoundPlayer(context);

    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        barra = BitmapFactory.decodeResource(getResources(), R.drawable.barra);
        fondo = BitmapFactory.decodeResource(getResources(), R.drawable.fondo);

        if (animThread != null) {
            return;
        }
        animThread = new MyAnimationThread(getHolder());
        animThread.start(); // To run the animation

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        stopThread(); // Stop the thread
    }

    public void stopThread() {
        animThread.stop = true;
    }


    // The inner thread class
    private class MyAnimationThread extends Thread {
        public boolean stop = false;
        private SurfaceHolder surfaceHolder;

        // Constructor
        public MyAnimationThread(SurfaceHolder surfaceHolder) {
            this.surfaceHolder = surfaceHolder;
        }

        public void run() {
            while (!stop) {
                // Control the crash against the wall
                // The movement of the ball
                x += ReboteX;
                y += ReboteY;
                // The conditions: Bouncing on the left
                if (x < radi) {
                    x = radi;
                    ReboteX = -ReboteX;
                    sound.playWallSound();
                }
                // Bouncing on the right
                if (x > getWidth() - radi) {
                    x = getWidth() - radi;
                    ReboteX = -ReboteX;
                    sound.playWallSound();
                }
                // Bouncing on the top
                if (y < radi) {
                    y = radi;
                    ReboteY = -ReboteY;
                    sound.playWallSound();
                }
                // Bouncing on the bottom
                if (y - radi > getHeight() + radi) {
                    y = getHeight() + radi;
                    x = (int) 400;
                    y = (int) 850;
                    ReboteY = -ReboteY;
                    sound.playOverSound();
                }
                if (y + radi > yPaleta) {
                    if (((x + radi > xPaleta) && (x - radi < xPaleta + Largo_Paleta))) {
                        ReboteY = -ReboteY;
                        sound.playHitSound();
                    }

                }

                if ((y - radi < brick3.PosY + 100) && (brick3.getVisibility())) {
                    if ((x + radi > brick3.PosX) && (x - radi < brick3.PosX + brick3.Largo_bottom)) {
                        ReboteY = -ReboteY;
                        brick3.setInvisible();
                        sound.playOverSound();
                    }
                }

                if ((y - radi < brick4.PosY + 100) && (brick4.getVisibility())) {
                    if ((x + radi > brick4.PosX) && (x - radi < brick4.PosX + brick4.Largo_bottom)) {
                        ReboteY = -ReboteY;
                        brick4.setInvisible();
                        sound.playOverSound();
                    }
                }

                if ((y - radi < brick5.PosY + 100) && (brick5.getVisibility())) {
                    if ((x + radi > brick5.PosX) && (x - radi < brick5.PosX + brick5.Largo_bottom)) {
                        ReboteY = -ReboteY;
                        brick5.setInvisible();
                        sound.playOverSound();
                    }
                }
                /*if ((y - radi < brick_f2.PosY + 100) && (brick_f2.getVisibility())){
                    if((x + radi > brick_f2.PosX)&& (x -radi < brick_f2.PosX + brick_f2.Largo_bottom)) {
                        ReboteY = -ReboteY;
                        brick_f2.setInvisible();
                        sound.playOverSound();
                    }
                }
                if ((y - radi < brick2_f2.PosY + 100) && (brick2_f2.getVisibility())){
                    if((x + radi > brick2_f2.PosX)&& (x -radi < brick2_f2.PosX + brick2_f2.Largo_bottom)) {
                        ReboteY = -ReboteY;
                        brick2_f2.setInvisible();
                        sound.playOverSound();
                    }
                }*/


                Canvas c = null;
                try {
                    c = surfaceHolder.lockCanvas(null);
                    synchronized (surfaceHolder) {
                        newDraw(c);
                    }
                } finally {
                    if (c != null) surfaceHolder.unlockCanvasAndPost(c);
                }

            } // while
        }
    }

    private void newDraw(Canvas c) {
        //MidaW:720 MidaH:1120
        try {
            //Pintem el Fondo
            Paint fondoP = new Paint();
            c.drawBitmap(fondo, 0, 0, fondoP);

            //Pintem la Bola
            circle.setColor(Color.RED);
            circle.setStyle(Paint.Style.FILL);
            c.drawCircle(x, y, radi, circle);

            //Pintem els Blocks
            rect.setColor(Color.YELLOW);
            rect.setStyle(Paint.Style.FILL);

            paint.setColor(Color.argb(255, 249, 129, 0));
            paint.setStyle(Paint.Style.FILL);

            /*
            c.drawRect(brick.PosX,brick.PosY,brick.Largo_top,brick.Largo_bottom,rect);
            brick.getVisibility();

            Brick brick2 = new Brick(PuntX + 140, PuntY, PuntX+140 + fila_1_dalt, PuntY+ fila_1_baix);
            c.drawRect(brick2.PosX,brick2.PosY,brick2.Largo_top,brick2.Largo_bottom,rect);
            brick2.getVisibility();
            */
            //Brickss brick3 = new Brickss(PuntX + 280, PuntY, PuntX+280 + fila_1_dalt, PuntY+ fila_1_baix);
            if (brick3.getVisibility()) {
                c.drawRect(brick3.PosX, brick3.PosY, brick3.Largo_top, brick3.Largo_bottom, rect);
            }

            //Brickss brick4 = new Brickss(PuntX + 420, PuntY, PuntX+420 + fila_1_dalt, PuntY+ fila_1_baix);
            if (brick4.getVisibility()) {
                c.drawRect(brick4.PosX, brick4.PosY, brick4.Largo_top, brick4.Largo_bottom, rect);
            }

            //Brickss brick5 = new Brickss(PuntX + 560, PuntY, PuntX+560 + fila_1_dalt, PuntY+ fila_1_baix);
            if (brick5.getVisibility()) {
                c.drawRect(brick5.PosX, brick5.PosY, brick5.Largo_top, brick5.Largo_bottom, rect);
            }
            /*
            Brickss brick_f2 = new Brickss(PuntX + 200, PuntY +250, PuntX+200+ fila_1_dalt,PuntY+250+ fila_1_baix);
            if(brick_f2.getVisibility()) {
                c.drawRect(brick_f2.PosX, brick_f2.PosY, brick_f2.Largo_top, brick_f2.Largo_bottom, rect);
            }

            //Brickss brick2_f2 = new Brickss(PuntX + 350, PuntY +250, PuntX+350+ fila_1_dalt,PuntY+250+ fila_1_baix);
            if(brick2_f2.getVisibility()) {
                c.drawRect(brick2_f2.PosX, brick2_f2.PosY, brick2_f2.Largo_top, brick2_f2.Largo_bottom, rect);
            }
            */

            //Pintem la Barra
            rect.setColor(Color.GREEN);
            rect.setStyle(Paint.Style.FILL);
            c.drawRect(xPaleta, yPaleta, xPaleta + Largo_Paleta, yPaleta + Altura_paleta, rect);
            c.drawBitmap(barra, xPaleta, yPaleta, rect);

            //Log.d("Pantalla","MidaW:"+c.getWidth() + "MidaH:"+c.getHeight());
        } catch (NullPointerException ex) {

        }
    }

    public boolean onTouchEvent(MotionEvent ev) {
        final int action = ev.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                ultimaXPaleta = ev.getX();
                ultimaYPaleta = ev.getY();

                break;
            }
            case MotionEvent.ACTION_MOVE: {
                // Calculate the distance moved
                final float dx = ev.getX() - ultimaXPaleta;
                final float dy = ev.getY() - ultimaYPaleta;
                xPaleta += dx; // Move the palette. Only in horizontal!
                if (xPaleta >= width) {
                    //xPaleta = 500;
                }
                // Remember this touch position for the next move event
                ultimaXPaleta = ev.getX();
                ultimaYPaleta = ev.getY();
                // Invalidate to request a redraw
                invalidate();
                break;
            }
        }
        return true;
    }
}





