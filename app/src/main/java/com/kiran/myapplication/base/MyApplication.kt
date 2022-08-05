package com.kiran.myapplication.base

import android.app.Application
import com.kiran.myapplication.di.getModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * My Application
 *
 * Created by Kiran Shaw on 05-07-2022
 *
 */

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            getModules()
        }

    }
}