package com.sohu.jetpacktest.adapter;

import android.databinding.BindingAdapter;
import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

@BindingMethods({
        @BindingMethod(type = ImageView.class, attribute = "android:src", method = "setImageResource")
})
public class ImageViewAdapter {
    @BindingAdapter(
            value = { "android:src" },
            requireAll = false
    )
    public static void setImageResource(ImageView imageView, @DrawableRes int drawable) {
        imageView.setImageResource(drawable);
    }
}
