package info.nukoneko.android.lineandpoint;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedIBundle){
        super.onCreate(savedIBundle);
        setContentView(new MainSurface(this));
    }
}
