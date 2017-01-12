package info.nukoneko.android.lineandpoint.controller;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Locale;

import info.nukoneko.android.lib.nkanimation.NKAnimationBaseController;

public class FpsController extends NKAnimationBaseController {
    private long mStartTime = 0;
    private int mCnt = 0;
    private Paint mPaint = new Paint();
    private float mFps;
    private final static int sN = 60;
    private final static int sFONT_SIZE = 20;

    public FpsController() {
        super();
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(sFONT_SIZE);
    }

    @Override
    public void onUpdate() {
        if (mCnt == 0) {
            mStartTime = System.currentTimeMillis();
        }
        if (mCnt == sN) {
            long t = System.currentTimeMillis();
            mFps = 1000.f / ((t - mStartTime) / (float) sN);
            mCnt = 0;
            mStartTime = t;
        }
        mCnt++;
    }

    @Override
    public void onDraw(Canvas c) {
        c.drawText(String.format(Locale.getDefault(), "%.1f FPS", mFps), 0, sFONT_SIZE - 2, mPaint);
    }
}
