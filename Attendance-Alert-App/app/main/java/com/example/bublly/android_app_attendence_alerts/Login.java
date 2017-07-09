package com.example.bublly.android_app_attendence_alerts;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.Calendar;

public class Login extends AppCompatActivity {

    private static Context context;
    public Button logout;
    public Button button;
    public Button button_D;
    public Button button_T;
    public Button button_alarmoff;
    final Calendar calendar = Calendar.getInstance();
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    int year_x,month_x,day_x,hour_x,minute_x;
    static final int Dialod_ID = 0;
    int D=0;
    private GoogleApiClient client;

    public void LogOut(View v)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

        button_D = (Button)findViewById(R.id.date_button);
        button_T = (Button)findViewById(R.id.time_button);
        button_alarmoff = (Button)findViewById(R.id.button4);
        year_x = calendar.get(Calendar.YEAR);
        month_x = calendar.get(Calendar.MONTH);
        day_x = calendar.get(Calendar.DAY_OF_MONTH);
        hour_x = calendar.get(Calendar.HOUR);
        minute_x = calendar.get(Calendar.MINUTE);
        this.context = this;


        button_alarmoff.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"Alarm OFF",Toast.LENGTH_SHORT).show();
                        alarmManager.cancel(pendingIntent);
                    }
                }
        );

        button_D.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        D=0;
                        showDialog(Dialod_ID+D);
                    }
                }
        );

        button_T.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        D = 1;
                        showDialog(Dialod_ID + D);
                     }
                }
        );

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    protected Dialog onCreateDialog(int id)
    {
        if(id == Dialod_ID)
            return new DatePickerDialog(this,datepickerListener ,year_x,month_x,day_x);
        else if (id == Dialod_ID+1)
            return new TimePickerDialog(this,timepickerListener ,hour_x,month_x,false);
        return  null;
    }

    private DatePickerDialog.OnDateSetListener datepickerListener = new DatePickerDialog.OnDateSetListener()
    {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year_x = year;
            month_x = monthOfYear+1;
            day_x = dayOfMonth;
            Toast.makeText(Login.this,day_x+"/"+month_x+"/"+year_x,Toast.LENGTH_SHORT).show();
        }
    };

    public TimePickerDialog.OnTimeSetListener timepickerListener = new TimePickerDialog.OnTimeSetListener()
    {
        @Override
        public void onTimeSet(TimePicker view, int hour, int minite) {

            Intent intent = new Intent(Login.context,Alarm_Receiver.class);

            hour_x = hour;
            minute_x = minite;
            Toast.makeText(Login.this,hour_x+" : "+minute_x,Toast.LENGTH_SHORT).show();


            pendingIntent = PendingIntent.getBroadcast(Login.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

        }
    };


    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.logout_activity_bar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Login Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.bublly.android_app_attendence_alerts/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Login Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.bublly.android_app_attendence_alerts/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
