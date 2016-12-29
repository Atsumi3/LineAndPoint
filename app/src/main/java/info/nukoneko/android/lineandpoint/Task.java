package info.nukoneko.android.lineandpoint;

import android.graphics.Canvas;
import android.view.MotionEvent;

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
