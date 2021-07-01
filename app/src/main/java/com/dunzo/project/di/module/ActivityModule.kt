package com.dunzo.project.di.module

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.dunzo.project.data.PhotosRepository
import com.dunzo.project.ui.base.BaseActivity
import com.dunzo.project.ui.main.MainViewModel
import com.dunzo.project.utils.viewmodel.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class ActivityModule (private val activity: BaseActivity<*>) {

    @Provides
    fun provideContext(
    ) : Context = activity

    @Provides
    fun provideMainViewModel(
        photosRepository: PhotosRepository
    ): MainViewModel = ViewModelProvider(
        activity, ViewModelProviderFactory(MainViewModel::class) {
            MainViewModel(photosRepository)
        }).get(MainViewModel::class.java)
}
