package com.dunzo.project.di.component

import com.dunzo.project.di.module.ActivityModule
import com.dunzo.project.di.scope.ActivityScope
import com.dunzo.project.ui.main.MainActivity
import dagger.Component


@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun inject(activity: MainActivity)

}