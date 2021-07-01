package com.dunzo.project.di.module

import android.content.Context
import androidx.room.Room
import com.dunzo.project.BuildConfig
import com.dunzo.project.PhotosApplication
import com.dunzo.project.data.local.database.PhotosDao
import com.dunzo.project.data.local.database.PhotosDatabase
import com.dunzo.project.utils.network.AppExecutors
import com.dunzo.project.utils.network.NetworkHelper
import com.dunzo.project.utils.network.Networking
import com.dunzo.project.utils.network.PhotosService
import com.dunzo.project.utils.rx.RxSchedulerProvider
import com.dunzo.project.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: PhotosApplication) {

    @Provides
    fun provideContext(): Context = application

    @Singleton
    @Provides
    fun provideNetworkHelper(): NetworkHelper = NetworkHelper(application)

    @Provides
    @Singleton
    fun provideUserDatabase(): PhotosDatabase =
        Room.databaseBuilder(application, PhotosDatabase::class.java, "photos_database")
            .fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideUserDao(db: PhotosDatabase): PhotosDao = db.photosDao()

    @Provides
    @Singleton
    fun provideNetworkService(): PhotosService =
        Networking.create(
            BuildConfig.BASE_URL)

    @Provides
    fun provideAppExecutors() : AppExecutors = AppExecutors()
}