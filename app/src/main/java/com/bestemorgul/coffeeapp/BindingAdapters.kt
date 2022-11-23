package com.bestemorgul.coffeeapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load
import com.bestemorgul.coffeeapp.data.model.CoffeeTypes
import com.bestemorgul.coffeeapp.ui.overview.CoffeeApiStatus

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imageUrl: String?) {

    imageUrl?.let {
        val imgUri = imageUrl.toUri().buildUpon().scheme("https").build()
        imageView.load(imgUri) {
            placeholder(R.drawable.ic_loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

@BindingAdapter("coffeeApiStatus")
fun bindStatus(statusImageView: ImageView, status: CoffeeApiStatus?) {

    when (status) {

        CoffeeApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_loading_animation)
        }

       CoffeeApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }

        else -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}

@BindingAdapter("formattedText")
fun TextView.setText(a: List<String>){
   text= a.joinToString (" , ")

}
