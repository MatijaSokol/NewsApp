package hr.ferit.matijasokol.newsapp.ui.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import hr.ferit.matijasokol.newsapp.R

fun ImageView.loadImage(url: String?) {
    Glide.with(this)
        .load(url)
        .placeholder(R.drawable.image_placeholder)
        .into(this)
}