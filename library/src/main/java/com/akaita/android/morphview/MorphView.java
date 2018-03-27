package com.akaita.android.morphview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.util.AttributeSet;

/**
 * Created by mikel on 27/03/2018.
 */

public class MorphView extends android.support.v7.widget.AppCompatImageView {

    @Nullable
    private AnimatedVectorDrawableCompat avdSecondToFirst;
    @Nullable
    private AnimatedVectorDrawableCompat avdFirstToSecond;
    private boolean showingAvdFirst = false;

    public MorphView(Context context) {
        super(context);
        init(context, null);
    }

    public MorphView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public MorphView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (isInEditMode()) {
            setImageResource(android.R.drawable.ic_media_play);
            return;
        }

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.MorphView,
                0, 0);

        @DrawableRes int avdFromRes;
        @DrawableRes int avdToRes;
        try {
            avdFromRes = a.getResourceId(R.styleable.MorphView_avdFirst, -1);
            avdToRes = a.getResourceId(R.styleable.MorphView_avdSecond, -1);
        } finally {
            a.recycle();
        }

        showingAvdFirst = true;
        avdFirstToSecond = AnimatedVectorDrawableCompat.create(getContext(), avdFromRes);
        avdSecondToFirst = AnimatedVectorDrawableCompat.create(getContext(), avdToRes);

        if (avdSecondToFirst == null || avdFirstToSecond == null) {
            throw new RuntimeException("Drawable is not a valid AnimatedVectorDrawable");
        } else {
            setImageDrawable(avdFirstToSecond);
        }
    }

    public void showAvdFirst() {
        if (!showingAvdFirst) {
            morph();
        }
    }

    public void showAvdSecond() {
        if (showingAvdFirst) {
            morph();
        }
    }

    public void morph() {
        AnimatedVectorDrawableCompat drawable = showingAvdFirst ? avdFirstToSecond : avdSecondToFirst;
        setImageDrawable(drawable);
        if (drawable != null) {
            drawable.start();
        }
        showingAvdFirst = !showingAvdFirst;
    }

    public void setAvdFirst(@NonNull AnimatedVectorDrawableCompat avdFirst) {
        avdFirstToSecond = avdFirst;
        invalidate();
    }

    public void setAvdSecond(@NonNull AnimatedVectorDrawableCompat avdSecond) {
        avdSecondToFirst = avdSecond;
        invalidate();
    }
}
