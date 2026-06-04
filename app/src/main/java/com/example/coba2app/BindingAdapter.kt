package com.example.coba2app

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("imageResource")
fun setImageResource(imageView: ImageView, imageRes: Int) {
    imageView.setImageResource(imageRes)
}