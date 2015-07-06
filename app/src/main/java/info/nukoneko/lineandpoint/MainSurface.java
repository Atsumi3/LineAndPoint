package info.nukoneko.lineandpoint;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Telneko on 2015/02/02.
 */
public class MainSurface extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    GameManager mGameManager = new GameManager(this);
    Thread mThread;
    public MainSurface(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        this.mThread = new Thread(this);
        this.mThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // 解像度度情報変更通知
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mThread = null;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        return this.mGameManager.onTouchEvent(event);
    }

    @Override
    public void run() {
        while (mThread != null){
            this.mGameManager.onUpdate();
            this.draw(getHolder());
        }
    }

    private void draw(SurfaceHolder holder){
        Canvas c = holder.lockCanvas();
        if ( c == null){
            return;
        }
        this.mGameManager.onDraw(c);
        holder.unlockCanvasAndPost(c);
    }
}
