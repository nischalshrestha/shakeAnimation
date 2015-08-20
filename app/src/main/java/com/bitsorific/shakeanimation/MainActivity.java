package com.bitsorific.shakeanimation;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private EditText textInput;
    private Button shakeButton;
    private Handler handler = new Handler();

    private static final Integer GREY = Color.parseColor("#D2D2D2");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shakeButton = (Button) findViewById(R.id.shakeButton);
        textInput = (EditText) findViewById(R.id.editText);

        final ObjectAnimator shaker = ObjectAnimator.ofFloat(textInput, "translationX", -15, 15);
        shaker.setDuration(30);
        shaker.setRepeatCount(5);
        shaker.setRepeatMode(Animation.REVERSE);

        //Pulse animate the color RED
        final ValueAnimator colorAnimatorUp = ObjectAnimator.ofInt(textInput.getBackground(), "color", GREY, Color.RED);
        colorAnimatorUp.setEvaluator(new ArgbEvaluator());
        colorAnimatorUp.setInterpolator(new DecelerateInterpolator());
        colorAnimatorUp.setDuration(150);

        final ValueAnimator colorAnimatorDown = ObjectAnimator.ofInt(textInput.getBackground(), "color", Color.RED, GREY);
        colorAnimatorDown.setEvaluator(new ArgbEvaluator());
        colorAnimatorDown.setInterpolator(new DecelerateInterpolator());
        colorAnimatorDown.setDuration(500);

        //Shake yer booty and pulse red
        shakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorSet set = new AnimatorSet();
                set.play(shaker).with(colorAnimatorUp);
                set.play(colorAnimatorDown).after(colorAnimatorUp);
                set.start();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
