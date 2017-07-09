package com.example.bublly.android_app_attendence_alerts;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Help extends AppCompatActivity {
    private static TextView logo_help;
    private static TextView how_to_use;
    private static TextView specifications;
    private static TextView about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        onButtonClickListener();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onButtonClickListener() {
        logo_help = (TextView)findViewById(R.id.textView12);
        how_to_use = (TextView)findViewById(R.id.textView13);
        specifications = (TextView)findViewById(R.id.textView10);
        about = (TextView)findViewById(R.id.textView11);
        how_to_use.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.bublly.android_app_attendence_alerts.How_to_use");
                        startActivity(intent);
                    }
                }
        );
        specifications.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.bublly.android_app_attendence_alerts.Specifications");
                        startActivity(intent);
                    }
                }
        );
       about.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.bublly.android_app_attendence_alerts.About");
                        startActivity(intent);
                    }
                }
        );
    }
}
