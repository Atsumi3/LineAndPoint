package info.nukoneko.android.lineandpoint;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import info.nukoneko.android.lineandpoint.controller.ObjectController;
import info.nukoneko.android.lineandpoint.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedIBundle) {
        super.onCreate(savedIBundle);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.animationView.setCanvasBackgroundColor(Color.argb(230, 0, 0, 0));
        binding.animationView.addController(new ObjectController());
    }
}
