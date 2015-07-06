package info.nukoneko.lineandpoint.controller;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

import java.util.ArrayList;

import info.nukoneko.lineandpoint.MainSurface;
import info.nukoneko.lineandpoint.Task;

/**
 * Created by Telneko on 2015/02/02.
 */
public class ObjectController extends Task {
    private static final int BALL_NUM = 20;
    private ArrayList<Circle> circleList = new ArrayList<>();
    private final static float __SIZE = 10;
    float phase, radius;
    int one = 7;

    public float MOUSE_X = 0;
    public float MOUSE_Y = 0;

    public float speed = 0.2f;

    private Paint _line = new Paint();

    public float width;
    public float height;

    public ObjectController(MainSurface holder){
        super(holder);

        for(int i = 0; i < BALL_NUM; i++){
            circleList.add(new Circle(0,0,__SIZE));
        }

        _line.setARGB(255, 127, 255, 127);
        _line.setAntiAlias(true);

    }
    @Override
    public boolean onUpdate(){

        width = holder.getWidth();
        height = holder.getHeight();

        if(MOUSE_X == 0) MOUSE_X = width / 2;
        if(MOUSE_Y == 0) MOUSE_Y = height / 2;

        if(width > height){
            radius = width / 4;
        }else{
            radius = height/ 4;
        }

        phase = phase + speed;

        for(int i = 0; i < circleList.size(); i++){
            circleList.get(i).x = (float) (Math.sin(Math.toRadians(phase * Math.round(MOUSE_X % 3)) * i / circleList.size() * one) * radius);
            circleList.get(i).y = (float) (Math.cos(Math.toRadians(phase * -Math.round(MOUSE_X % 7)) * i / circleList.size() * one) * radius);
        }

        return true;
    }

    @Override
    public void onDraw(Canvas c) {
        float b1 = Math.abs(width - MOUSE_X);
        float b2 = Math.abs(height - MOUSE_Y);

        float c1 = width/2 + (MOUSE_X - width/2) % width;
        float c2 = height/2 + (MOUSE_Y - height/2) % height;

        c.drawCircle(b1,b2,__SIZE, _line);
        c.drawCircle(c1,c2,__SIZE, _line);

        c.drawLine(b1,b2,c1,c2, _line);

        for(int i = 0 ; i < circleList.size();i++){
            float MAIN_BALL_X = width/2 + circleList.get(i).x % width;
            float MAIN_BALL_Y = height/2 + circleList.get(i).y % height;

            float l1 = (i == 0) ? circleList.get(circleList.size() -1).x : circleList.get(i - 1).x;
            float l2 = (i == 0) ? circleList.get(circleList.size() -1).y : circleList.get(i - 1).y;

            c.drawLine(MAIN_BALL_X, MAIN_BALL_Y, b1,b2, _line);
            c.drawLine(MAIN_BALL_X, MAIN_BALL_Y, c1,c2, _line);
            c.drawCircle(MAIN_BALL_X, MAIN_BALL_Y, __SIZE, _line);

            c.drawLine(MAIN_BALL_X, MAIN_BALL_Y, width / 2 + l1, height / 2 + l2, _line);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent eve){
        MOUSE_X = eve.getX();
        MOUSE_Y = eve.getY();
        return true;
    }

    private class Circle{
        float x, y, r;
        Circle(float x, float y, float z){
            this.x = x;
            this.y = y;
            this.r = z;
        }
    }
}
