package com.boymask.training.math;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import static android.view.View.SYSTEM_UI_FLAG_FULLSCREEN;

public class MathActivity extends AppCompatActivity {
    private GameView mGameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        Bundle b = getIntent().getExtras();
        MathParameters mathParameters = (MathParameters) b.getSerializable("params");


        // Create a GameView and bind it to this activity.
        // You don't need a ViewGroup to fill the screen, because the system
        // has a FrameLayout to which this will be added.
        mGameView = new GameView(this);
        mGameView.setMathParameters(mathParameters);
        mGameView.setActivity(this);
        // Android 4.1 and higher simple way to request fullscreen.
        mGameView.setSystemUiVisibility(SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(mGameView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mGameView.pause();
    }

    /**
     * Resumes game when activity is resumed.
     */
    @Override
    protected void onResume() {
        super.onResume();
        mGameView.resume();
    }
}