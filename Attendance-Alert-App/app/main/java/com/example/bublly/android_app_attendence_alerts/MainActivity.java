package com.example.bublly.android_app_attendence_alerts;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    New_Registartion new_registartion = new New_Registartion(this);

    private static Button button_Login;
    private static EditText user_name;
    private static EditText pwd;
    private static TextView logo;
    private static TextView register;
    private static TextView calendar;
    private static TextView help;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*android.support.v7.app.ActionBar action = getSupportActionBar();
        action.setLogo(R.drawable.ic_launcher);
        action.setDisplayUseLogoEnabled(true);
        action.setDisplayShowHomeEnabled(true);*/

        onButtonClickListener();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g    .co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void onButtonClickListener() {
        logo = (TextView) findViewById(R.id.textView1);
        user_name = (EditText) findViewById(R.id.editText);
        pwd = (EditText) findViewById(R.id.editText2);
        button_Login = (Button) findViewById(R.id.button);
        register = (TextView) findViewById(R.id.textView2);
        calendar = (TextView) findViewById(R.id.textView);
        help = (TextView) findViewById(R.id.textView3);
        button_Login.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                            String username = user_name.getText().toString();
                            String password = pwd.getText().toString();

                            if(username.length() != 0 && password.length() != 0)
                            {
                                String pass_word = new_registartion.verifyInformation(username);

                                if(pass_word.equals(password))
                                {
                                    Intent intent = new Intent("com.example.bublly.android_app_attendence_alerts.Login");
                                    Toast.makeText(MainActivity.this,"LogIn Successful !!!",Toast.LENGTH_SHORT).show();
                                    startActivity(intent);
                                    user_name.setText(null);
                                    pwd.setText(null);
                                    Toast.makeText(MainActivity.this,"Welcome Professor "+username,Toast.LENGTH_LONG).show();
                                }
                                else
                                {
                                    Toast.makeText(MainActivity.this,"Invalid Username or Password !!!",Toast.LENGTH_LONG).show();
                                    user_name.setText(null);
                                    pwd.setText(null);
                                }
                            }

                            else
                            {
                                Toast.makeText(MainActivity.this,"Fields can't be empty !!!",Toast.LENGTH_LONG).show();

                            }

                    }
                }
        );
        register.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.bublly.android_app_attendence_alerts.Registration");
                        startActivity(intent);
                    }
                }
        );
        calendar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.bublly.android_app_attendence_alerts.Calendar");
                        startActivity(intent);
                    }
                }
        );
        help.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.bublly.android_app_attendence_alerts.Help");
                        startActivity(intent);
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

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
                "Main Page", // TODO: Define a title for the content shown.
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
                "Main Page", // TODO: Define a title for the content shown.
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
