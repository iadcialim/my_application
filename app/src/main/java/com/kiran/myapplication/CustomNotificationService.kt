package com.kiran.myapplication


import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService

/**
 * My Application
 *
 * Created by Kiran Shaw on 09-08-2022
 */

class CustomNotificationService : FirebaseMessagingService() {


    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
        Log.d("FCM Token: ", p0)
    }
}