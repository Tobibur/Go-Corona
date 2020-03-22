package com.tobibur.covid_19.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

fun ViewGroup.inflate(layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(this.context).inflate(layoutRes, this, attachToRoot)
}

fun ImageView.load(imgRes: Any, context: Context) {
    Glide.with(context)
        .load(imgRes)
        .into(this)
}

fun Context.toast(msg: String?, len: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, len).show()
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}