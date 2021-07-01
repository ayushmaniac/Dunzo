package com.dunzo.project

import android.app.Application
import com.dunzo.project.di.component.ApplicationComponent
import com.dunzo.project.di.component.DaggerApplicationComponent
import com.dunzo.project.di.module.ApplicationModule


class PhotosApplication : Application(){

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        getDependencies()
    }

    private fun getDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }

}