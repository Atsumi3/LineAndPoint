package info.nukoneko.lineandpoint;

import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * Created by Telneko on 2015/02/02.
 */
public abstract class Task {
    public MainSurface holder;

    public Task(MainSurface holder) {
        this.holder = holder;
    }

    public boolean onUpdate() {
        return true;
    }

    abstract public void onDraw(Canvas c);

    public boolean onTouchEvent(MotionEvent event){
        return true;
    }
}
