package com.bitsorific.shakeanimation.shaker;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;

/**
 * Created by nischal on 8/20/15.
 */
public class Shaker {

    private ObjectAnimator shaker;
    private ObjectAnimator colorAnimatorUp;
    private ObjectAnimator colorAnimatorDown;

    public Shaker(View view, float x, float xDelta, int colorFrom, int colorTo){

        shaker = ObjectAnimator.ofFloat(view, "translationX", x, xDelta);
        shaker.setDuration(30);
        shaker.setRepeatCount(5);
        shaker.setRepeatMode(Animation.REVERSE);

        //Pulse animate the color RED
        colorAnimatorUp = ObjectAnimator.ofInt(view.getBackground(), "color", colorFrom, colorTo);
        colorAnimatorUp.setEvaluator(new ArgbEvaluator());
        colorAnimatorUp.setInterpolator(new DecelerateInterpolator());
        colorAnimatorUp.setDuration(150);

        colorAnimatorDown = ObjectAnimator.ofInt(view.getBackground(), "color", colorTo, colorFrom);
        colorAnimatorDown.setEvaluator(new ArgbEvaluator());
        colorAnimatorDown.setInterpolator(new DecelerateInterpolator());
        colorAnimatorDown.setDuration(500);

    }

    public void shake(){
        AnimatorSet set = new AnimatorSet();
        set.play(shaker).with(colorAnimatorUp);
        set.play(colorAnimatorDown).after(colorAnimatorUp);
        set.start();
    }


}
