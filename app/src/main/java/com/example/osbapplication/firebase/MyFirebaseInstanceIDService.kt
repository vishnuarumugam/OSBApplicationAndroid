package com.example.osbapplication.firebase

import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class MyFirebaseInstanceIDService: FirebaseMessagingService() {


    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.e("onReceive", "::"+System.currentTimeMillis())

        // Check if message contains a data payload.


        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }
}
