package com.kiran.myapplication.di

import android.app.Application
import androidx.room.Room
import com.google.gson.GsonBuilder
import com.kiran.myapplication.data.AppDatabase
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * My Application
 *
 * Created by Kiran Shaw on 05-07-2022
 */

fun getModules() = listOf(
    databaseModule,
    networkModule,
    utilsModule
)

val databaseModule = module {
    val dBName = "sampleRoom.db"
    fun provideDatabase(context: Application): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, dBName)
            .allowMainThreadQueries()
            .build()

    }
    single { provideDatabase(get()) }
}
val networkModule = module {

    fun provideOkHTTPClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    fun provideRetrofit(
        client: OkHttpClient,
        baseURL: String
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .baseUrl(baseURL)
            .client(client)
            .build()
    }

    single { provideRetrofit(get(), "https://swapi.dev/api/") }
    single { provideOkHTTPClient() }
}

val utilsModule = module {
//    fun provideContext()

}