package info.nukoneko.lineandpoint;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Telneko on 2015/02/02.
 */
public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedIBundle){
        super.onCreate(savedIBundle);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(new MainSurface(this));
    }
}
