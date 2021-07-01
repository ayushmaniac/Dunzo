package com.dunzo.project.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dunzo.project.R
import com.dunzo.project.data.local.model.Photo

class PhotosAdapter(private var data: MutableList<Photo>?) : RecyclerView.Adapter<PhotosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder =
        PhotosViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_photos, parent, false))

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        val photo = data?.get(position)
        holder.bindPhotos(photo)

    }

    override fun getItemCount(): Int = data?.size ?: 0

    fun refreshLists() {
        data?.clear()
        notifyDataSetChanged()
    }

    fun addNewData(data: MutableList<Photo>?) {
        this.data = data
        notifyDataSetChanged()
    }
}