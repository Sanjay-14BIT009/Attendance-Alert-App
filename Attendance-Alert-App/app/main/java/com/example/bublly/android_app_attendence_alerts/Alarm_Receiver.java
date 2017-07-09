package com.example.bublly.android_app_attendence_alerts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by BUBLLY on 28-04-2016.
 */
public class Alarm_Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("Alarm Is On","Try It !!!");

        Intent service_intent = new Intent(context, Notify.class);

        context.startService(service_intent);
    }
}
