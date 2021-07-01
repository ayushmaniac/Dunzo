package com.dunzo.project.ui.main

import com.dunzo.project.data.PhotosRepository
import com.dunzo.project.ui.base.BaseViewModel

class MainViewModel(private val photosRepository: PhotosRepository) : BaseViewModel(){

    fun getPhotos(page : Int, query : String) = photosRepository.getFlickrPhotosFromNetwork(page, query)


}