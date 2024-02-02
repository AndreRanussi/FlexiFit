package com.flexidevapps.flexifit.di

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.flexidevapps.flexifit.core.data.preferences.DefaultPreferences
import com.flexidevapps.flexifit.core.domain.preferences.Preferences
import com.flexidevapps.flexifit.core.domain.usecases.DateValidation
import com.flexidevapps.flexifit.core.domain.usecases.FilterOutDigits
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(
        app: Application
    ) : SharedPreferences {
        return app.getSharedPreferences("shared_pref", MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providePreferences(sharedPreferences: SharedPreferences) : Preferences {
        return DefaultPreferences(sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideFilterOutDigitsUseCase(): FilterOutDigits {
        return FilterOutDigits()
    }

    @Provides
    @Singleton
    fun provideDataValidationUserCase(): DateValidation {
        return DateValidation()
    }

}