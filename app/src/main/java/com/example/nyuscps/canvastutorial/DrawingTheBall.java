package com.example.nyuscps.canvastutorial;

//from youtube.com/user/MyBringBack Android tutorials


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class DrawingTheBall extends View {

    Bitmap bball;
    int x,y; //x-axis and y-axis positions of ball animation


    public DrawingTheBall(Context context) {

        super(context);
        bball = BitmapFactory.decodeResource(getResources(), R.drawable.bball);
        x = 0;
        y = 0; // x & y are going to be called onto canvas via the onDraw() method to change position of the ball
    }

        @Override
        protected void onDraw (Canvas canvas){
            super.onDraw(canvas);

//tut 1.26 - drawing the rectangle:

            Rect blueRect = new Rect();
            blueRect.set(0, 0, 40, 40); //left, top, right, bottom
            Paint blue = new Paint(); //setting up blue variable to paint rectangle blue
            blue.setColor(Color.BLUE);
            blue.setStyle(Paint.Style.FILL);


            canvas.drawRect(blueRect, blue); //This makes the blue rectangle finally appear on Canvas "canvas"




//tut 1.27 - Importing & animating the ball bitmap:

            if(x < canvas.getWidth()) {x +=10;} else {x = 0;} //to prevent the ball from going off-screen, or off canvas
            if(y <canvas.getHeight()){y +=10;} else {y = 0;} //the += for x & y adds 10 each time the onDraw() method is called


canvas.drawBitmap(bball, x, y, null);
invalidate(); //this is to get the onDraw() function to call x & y over and over again. Without this, bball won't move



        }
}


