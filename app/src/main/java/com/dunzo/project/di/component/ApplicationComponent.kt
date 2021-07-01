package com.dunzo.project.di.component

import android.content.Context
import com.dunzo.project.PhotosApplication
import com.dunzo.project.data.PhotosRepository
import com.dunzo.project.di.module.ApplicationModule
import com.dunzo.project.utils.network.AppExecutors
import com.dunzo.project.utils.network.NetworkHelper
import com.dunzo.project.utils.rx.SchedulerProvider
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: PhotosApplication)

    fun getContext() : Context

    fun getNetworkHelper(): NetworkHelper

    fun getPhotosRepository() : PhotosRepository

    fun getAppExecutors() : AppExecutors

}