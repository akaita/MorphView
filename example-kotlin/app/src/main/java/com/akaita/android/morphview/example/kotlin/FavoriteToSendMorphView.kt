package com.akaita.android.morphview.example.kotlin

/**
 * Created by mikel on 26/03/2018.
 */

import android.content.Context
import android.support.graphics.drawable.AnimatedVectorDrawableCompat
import android.util.AttributeSet

class FavoriteToSendMorphView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : android.support.v7.widget.AppCompatImageView(context, attrs, defStyleAttr) {

    private var sendToFavorite: AnimatedVectorDrawableCompat? = null
    private var favoriteToSend: AnimatedVectorDrawableCompat? = null
    private var showingFavorite: Boolean = false

    init {
        showingFavorite = true
        favoriteToSend = AnimatedVectorDrawableCompat.create(context, R.drawable.avd_favorite_to_send)
        sendToFavorite = AnimatedVectorDrawableCompat.create(context, R.drawable.avd_send_to_favorite)
        setImageDrawable(favoriteToSend)
    }

    fun showFavorite() {
        if (!showingFavorite) {
            morph()
        }
    }

    fun showSend() {
        if (showingFavorite) {
            morph()
        }
    }

    fun morph() {
        val drawable = if (showingFavorite) favoriteToSend else sendToFavorite
        setImageDrawable(drawable)
        drawable?.start()
        showingFavorite = !showingFavorite
    }
}
