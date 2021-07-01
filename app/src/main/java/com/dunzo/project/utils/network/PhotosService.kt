package com.dunzo.project.utils.network

import androidx.lifecycle.LiveData
import com.dunzo.project.data.remote.PhotoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotosService {


    @GET(Endpoints.SEARCH_POINT)
    fun getFlickrPhotos(
        @Query("method") method : String,
        @Query("api_key") apiKey: String,
        @Query("text") text : String,
        @Query("format") format: String,
        @Query("nojsoncallback") noJsonCallBack : Int,
        @Query("per_page") perPage: Int,
        @Query("page") page : Int
    ): LiveData<Resource<PhotoResponse>>
}