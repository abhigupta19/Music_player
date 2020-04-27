package com.sar.user.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

public class MyService extends Service {
    MediaPlayer mediaPlayer;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
           }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer=MediaPlayer.create(this,R.raw.ram);
        mediaPlayer.start();
        Intent nor=new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,nor,0);
        Notification notification=new NotificationCompat.Builder(this,nortifaction.channal).setContentTitle("example").setContentIntent(pendingIntent).build();
        startForeground(1,notification);




        return START_REDELIVER_INTENT ;

    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        stopForeground(true);
    }

}
