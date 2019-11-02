package com.example.simple_sprint13_challenge.di

import android.app.Application
import com.example.simple_sprint13_challenge.view.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindApplication(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(mainActivity: MainActivity)
}
