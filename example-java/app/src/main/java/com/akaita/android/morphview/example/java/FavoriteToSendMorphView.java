package com.akaita.android.morphview.example.java;

/**
 * Created by mikel on 27/03/2018.
 */

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.util.AttributeSet;

public class FavoriteToSendMorphView extends android.support.v7.widget.AppCompatImageView {

    @Nullable
    private AnimatedVectorDrawableCompat sendToFavorite;
    @Nullable
    private AnimatedVectorDrawableCompat favoriteToSend;
    private boolean showingFavorite = false;

    public FavoriteToSendMorphView(Context context) {
        super(context);
        init();
    }

    public FavoriteToSendMorphView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FavoriteToSendMorphView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        showingFavorite = true;
        favoriteToSend = AnimatedVectorDrawableCompat.create(getContext(), R.drawable.avd_favorite_to_send);
        sendToFavorite = AnimatedVectorDrawableCompat.create(getContext(), R.drawable.avd_send_to_favorite);
        setImageDrawable(favoriteToSend);
    }

    public void showFavorite() {
        if (!showingFavorite) {
            morph();
        }
    }

    public void showSend() {
        if (showingFavorite) {
            morph();
        }
    }

    public void morph() {
        AnimatedVectorDrawableCompat drawable = showingFavorite ? favoriteToSend : sendToFavorite;
        setImageDrawable(drawable);
        if (drawable != null) {
            drawable.start();
        }
        showingFavorite = !showingFavorite;
    }

}
