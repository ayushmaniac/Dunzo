package com.dunzo.project.ui.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dunzo.project.data.local.model.Photo
import kotlinx.android.synthetic.main.row_photos.view.*

class PhotosViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    fun bindPhotos(photo: Photo?) {
        val toLoadImage = "https://farm"+photo?.farm+"."+"static.flickr.com/"+photo?.server+"/"+photo?.id+"_"+photo?.secret+"_m.jpg"
        Glide.with(itemView.context)
            .load(toLoadImage)
            .into(itemView.ivPhoto)
    }
}