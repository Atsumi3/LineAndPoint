package info.nukoneko.lineandpoint;

import android.graphics.Canvas;
import android.view.MotionEvent;

import java.util.LinkedList;

import info.nukoneko.lineandpoint.controller.FpsController;
import info.nukoneko.lineandpoint.controller.ObjectController;

/**
 * Created by Telneko on 2015/02/02.
 */
public class GameManager {
    MainSurface mParent = null;
    private LinkedList<Task> mTaskList = new LinkedList<>();

    GameManager(MainSurface surface){
        this.mParent = surface;
        //this.mTaskList.add(new FpsController(surface));
        this.mTaskList.add(new ObjectController(surface));
    }

    public boolean onUpdate(){
        for(Task t : this.mTaskList){
            if(!t.onUpdate()) this.mTaskList.remove(t);
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent event){
        for(Task t : this.mTaskList){
            t.onTouchEvent(event);
        }
        return true;
    }

    public void onDraw(Canvas c){
        c.drawARGB(230, 0,0,0);
        for(Task t : this.mTaskList){
            t.onDraw(c);
        }
    }
}
