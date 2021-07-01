package com.dunzo.project.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dunzo.project.BuildConfig
import com.dunzo.project.data.local.model.Photo
import com.dunzo.project.data.local.model.Photos

@Database(
    entities = [Photo::class],
    version = BuildConfig.VERSION_CODE,
    exportSchema = false
)
abstract class PhotosDatabase : RoomDatabase(){

    abstract fun photosDao(): PhotosDao

}