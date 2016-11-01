package com.example.sammyo.drawingforfun;

/**
 * Created by Sammy O on 10/28/2016.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
//import android.graphics.Path;
//import android.util.AttributeSet;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class CustomView extends View{
    private Paint drawPaint;
    private List<Point> circlePoints;
    private float x,y;
    Context c;
    boolean pressed;



    public CustomView(Context context,  AttributeSet attrs){
        super(context, attrs);
        c = context;
        drawPaint = new Paint();
        drawPaint.setColor(Color.RED);
        setupPaint(); // same as before
        circlePoints = new ArrayList<Point>();
        x = 0;
        y = 0;
        pressed = false;

    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Point p : circlePoints) {
            canvas.drawCircle(p.getX(), p.getY(), 5, drawPaint);
        }
        if(pressed == true){
            circlePoints.add(new Point((int) x, (int) y));
            pressed = false;
        }
    }

    // Append new circle each time user presses on screen
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();
        pressed = true;
        // indicate view should be redrawn
        invalidate();
        return true;
    }
    protected void startTouch(float x, float y) {
        this.x = x;
        this.y = y;
    }

    private void setupPaint() {
        // same as before
        drawPaint.setStyle(Paint.Style.FILL); // change to fill
        // ...
    }

    class Point{

        int x,y;

        public Point(int x2, int y2){
            x = x2;
            y = y2;
        }

        public int getX(){return x;}
        public int getY(){return y;}
    }
}


