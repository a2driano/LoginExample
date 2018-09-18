package com.mind.andrew.login.utils.adapter

import android.databinding.BindingAdapter
import android.support.design.widget.TextInputLayout

@BindingAdapter("app:error")
fun setError(view: TextInputLayout, error: String) {
    if (view.isErrorEnabled)
        view.error = error
    else
        view.error = null
}