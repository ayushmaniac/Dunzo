package com.dunzo.project.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.dunzo.project.R
import com.dunzo.project.data.local.model.Photo

class PhotosPagedAdapter : ListAdapter<Photo, PhotosViewHolder>(PHOTO_DIFF) {

    companion object {
        object PHOTO_DIFF : DiffUtil.ItemCallback<Photo>() {
            override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
                return oldItem.title.equals(newItem.title)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder = PhotosViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_photos, parent, false))


    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        val photo = getItem(position)
        holder.bindPhotos(photo)
    }

}