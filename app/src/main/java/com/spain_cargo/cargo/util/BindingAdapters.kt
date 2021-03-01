package com.spain_cargo.cargo.util

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.github.marlonlom.utilities.timeago.TimeAgo
import com.github.marlonlom.utilities.timeago.TimeAgoMessages
import com.google.android.material.card.MaterialCardView
import com.spain_cargo.cargo.R
import com.spain_cargo.cargo.ui.base.BaseDataItemsAdapter
import java.util.*


@BindingAdapter("imageUrl")
fun loadImage(view: SimpleDraweeView, imageUrl: String?) {
    view.setImageURI(imageUrl)
}

@BindingAdapter("timeAgo")
fun timeAgo(view: TextView, date: Date?) {

    val locale = Locale.forLanguageTag("ar")
    val messages = TimeAgoMessages.Builder()
        .withLocale(locale).build()
    date?.let {
        view.text = TimeAgo.using(date.time, messages)
    }
}


@BindingAdapter(value = ["items"])
fun <T> RecyclerView.setItems(items: MutableList<T>?) {
    items?.let {
        (this.adapter as? BaseDataItemsAdapter<T>)?.apply {
            setItems(it)
        }
    }
}


// TODO: check if u don't need this func
/**
 * this func for completed and refundable status(false, true)
 * */
@BindingAdapter(value = ["status"])
fun MaterialCardView.setStatus(is_active: Boolean) {
    if (is_active) {
        this.setBackgroundColor(context.resources.getColor(R.color.colorDisable))
        isClickable = false
    }
}


