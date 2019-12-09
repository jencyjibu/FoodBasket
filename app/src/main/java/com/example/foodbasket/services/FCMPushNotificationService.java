package com.example.foodbasket.services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.example.foodbasket.R;
import com.example.foodbasket.ui.BuyOrSell;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class FCMPushNotificationService extends FirebaseMessagingService {

    private static final String TAG = "FCMPushNotificationSrv";
    private static final String CHANNEL_ID = "101";

    @Override
    public void onNewToken(String token){
        super.onNewToken(token);
        Log.d(TAG,"New Token: "+token );
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d(TAG,"Message Data Payload: "+remoteMessage.getData());

        //STEP1: PREPARE AND SHOW NOTIFICATION
        if(remoteMessage.getData()!=null){
            Map<String, String> data = remoteMessage.getData();
            showNotification(data);
        }
    }

    private void showNotification(Map<String,String> data){
        Intent intent = new Intent(this, BuyOrSell.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK / Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 , intent,PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri  = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this,CHANNEL_ID)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background))
                .setSmallIcon(R.drawable.ic_small_foodbasket_24dp)
                .setContentTitle(data.get("contentTitle"))
                .setContentText(data.get("contentText"))
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC);

        NotificationManager notificationManager =
                (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        if(notificationManager!=null){
            createNotificationChannel(notificationManager);
            notificationManager.notify(0,notificationBuilder.build());
        }

    }

    /**
     * CREATE THE NOTIFICATIONCHANNEL
     * THIS IS REQIURED FOR API 26+(ANDROIDOREO)AND IS SAFELY IGNORED BY OTHER ANDROID VERSIONS.
     *
     * @param notificationManager NotificationManager object
     */
    private void createNotificationChannel(NotificationManager notificationManager) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            Log.d(TAG, "Inside createNotificationChannel");
            NotificationChannel notificationChannel =new NotificationChannel(CHANNEL_ID,
                    "Notification", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);;
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Food Basket Notifications");

            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    /**
     *
     */
}

