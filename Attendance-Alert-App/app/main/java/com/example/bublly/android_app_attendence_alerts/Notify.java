package com.example.bublly.android_app_attendence_alerts;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by BUBLLY on 28-04-2016.
 */
public class Notify extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("LocalService", "Received start id " + startId + ": " + intent);


            Intent Service_intent = new Intent(this.getApplicationContext(),Login.class);

            PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                    Service_intent, 0);

            Notification notification = new Notification.Builder(this)
                    .setSmallIcon(R.drawable.ic_launcher)  // the status icon
                    .setTicker("TickerTitle")  // the status text
                    .setWhen(System.currentTimeMillis())  // the time stamp
                    .setContentTitle("Pending Attendence Alerts")  // the label of the entry
                    .setContentText("Have You Mark Your Attendence ???")  // the contents of the entry
                    .setContentIntent(contentIntent)  // The intent to send when the entry is clicked
                    .addAction(R.drawable.ic_launcher1, "Yes", contentIntent)
                    .addAction(R.drawable.ic_launcher1, "No", contentIntent)
                    .build();

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(0, notification);

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        // Cancel the persistent notification.
        // Tell the user we stopped.
        Toast.makeText(this,"On Destroy", Toast.LENGTH_SHORT).show();
    }


}
