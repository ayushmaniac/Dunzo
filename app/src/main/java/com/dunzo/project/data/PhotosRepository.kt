package com.dunzo.project.data

import androidx.lifecycle.LiveData
import com.dunzo.project.data.local.database.PhotosDao
import com.dunzo.project.data.local.model.Photo
import com.dunzo.project.data.remote.PhotoResponse
import com.dunzo.project.utils.Constants
import com.dunzo.project.utils.network.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotosRepository @Inject constructor(
    private val networkService: PhotosService,
    private val userDao: PhotosDao,
    private val networkHelper: NetworkHelper,
    private val appExecutors: AppExecutors
) {

/*
    fun getFlickrPhotos(
        pageNo: Int,
        query: String
    ): LiveData<Resource<MutableList<Photo>?>> {
        return object : NetworkBoundResource<MutableList<Photo>, PhotoResponse>(appExecutors) {
            override fun saveCallResult(item: PhotoResponse) {
                saveData(item)
            }
            override fun shouldFetch(data: MutableList<Photo>?): Boolean = true
*/
/*
                networkHelper.isNetworkConnected()
*//*

            override fun loadFromDb(): LiveData<MutableList<Photo>> = getPhotos()
            override fun createCall(): LiveData<Resource<PhotoResponse>> =
                createNetworkCall(pageNo, query)
        }.asLiveData()
    }
*/

    fun getFlickrPhotosFromNetwork(
        pageNo: Int,
        query : String
    ): LiveData<Resource<PhotoResponse>> {
        return object : NetworkResource<PhotoResponse>(){
            override fun createCall(): LiveData<Resource<PhotoResponse>> = createNetworkCall(pageNo, query)


        }.asLiveData()
    }

    private fun createNetworkCall(pageNo: Int, query: String): LiveData<Resource<PhotoResponse>> {
        return networkService.getFlickrPhotos(
            Constants.METHOD,
            Constants.API_KEY,
            query,
            Constants.FORMAT,
            Constants.NO_JSON_CALLBACK,
            Constants.PER_PAGE,
            pageNo
        )
    }

  /*  private fun getPhotos(): LiveData<MutableList<Photo>> = userDao.getPhotos()

    private fun saveData(item: PhotoResponse) {
        appExecutors.diskIO().execute {
            userDao.savePhotos(item.photos?.photo)
        }

    }
     fun removeAll(){
       appExecutors.diskIO().execute {
           userDao.removeAll()
       }
    }
*/

}