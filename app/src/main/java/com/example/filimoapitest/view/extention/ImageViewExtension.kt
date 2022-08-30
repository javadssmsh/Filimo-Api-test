package com.example.filimoapitest.view.extention

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.filimoapitest.R

class ImageViewExtension {

    fun ImageView.loadImage(
        url: String?,
        @DrawableRes placeholder: Int = R.drawable.ic_image_placeholder,
    ) {
        Glide
            .with(context)
            .load(url)
            .centerCrop()
            .placeholder(placeholder)
            .into(this)
    }

    companion object {
        @JvmStatic
        @BindingAdapter(
            "imageUrl",
        )
        fun ImageView.bindImageUrl(
            imageUrl: String?,
        ) {
            Glide
                .with(context)
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.ic_image_placeholder)
                .into(this)
        }
    }

}