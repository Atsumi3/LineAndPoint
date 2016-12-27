package info.nukoneko.android.lineandpoint.controller;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import info.nukoneko.android.lineandpoint.MainSurface;
import info.nukoneko.android.lineandpoint.Task;

/**
 * Created by Telneko on 2015/02/02.
 */
public class FpsController extends Task {
    private long mStartTime = 0;
    private int mCnt = 0;
    private Paint mPaint = new Paint();
    private float mFps;
    private final static int sN = 60;
    private final static int sFONT_SIZE = 20;
    public FpsController(MainSurface holder){
        super(holder);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(sFONT_SIZE);
    }
    @Override
    public boolean onUpdate(){
        if(mCnt == 0) {
            mStartTime = System.currentTimeMillis();
        }
        if(mCnt == sN) {
            long t = System.currentTimeMillis();
            mFps = 1000.f/((t-mStartTime)/(float)sN);
            mCnt = 0;
            mStartTime = t;
        }
        mCnt++;
        return true;
    }
    @Override
    public void onDraw(Canvas c){
        //c.drawText(String.format("%.1f", mFps), 0, sFONT_SIZE-2, mPaint);
    }
}
