package com.dunzo.project.data.local.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dunzo.project.data.local.model.Photo

@Dao
interface PhotosDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePhotos(photos: List<Photo>?)

    @Query("SELECT * FROM photos_table")
    fun getPhotos(): LiveData<MutableList<Photo>>

    @Query("DELETE FROm photos_table")
    fun removeAll()


}