package com.example.bublly.android_app_attendence_alerts;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration extends AppCompatActivity {
    private static Button button_save;
    private static Button button_reset;
    private static EditText get_username;
    private static EditText get_userid;
    private static EditText get_password;
    private static EditText get_reset_password;
    private static TextView title;
    private static TextView new_username;
    private static TextView new_userid;
    private static TextView new_password;
    private static TextView new_reset_password;
    Context context = this;
    New_Registartion new_registartion;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button_save = (Button)findViewById(R.id.button2);
        button_reset = (Button)findViewById(R.id.button3);
        get_username = (EditText)findViewById(R.id.editText3);
        get_password = (EditText)findViewById(R.id.editText5);
        get_reset_password = (EditText)findViewById(R.id.editText6);
        title = (TextView)findViewById(R.id.textView4);
        new_username = (TextView)findViewById(R.id.textView5);
        new_password = (TextView)findViewById(R.id.textView7);
        new_reset_password = (TextView)findViewById(R.id.textView8);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void addInfo(View V) {

        Spinner spinner=(Spinner)findViewById(R.id.spinner);
        String F_name = spinner.getSelectedItem().toString();
        String name = get_username.getText().toString();
        String id = get_userid.getText().toString();
        String password = get_password.getText().toString();
        String reset_password = get_reset_password.getText().toString();

        if (F_name.length() == 0) {
            Toast.makeText(getBaseContext(), "FIELD CANNOT BE EMPTY", Toast.LENGTH_LONG).show();
        } else if(name.length() == 0) {
            get_username.requestFocus();
            get_username.setError("FIELD CANNOT BE EMPTY");
        } else if (id.length() == 0) {
            get_userid.requestFocus();
            get_userid.setError("FIELD CANNOT BE EMPTY");
        } else if (id.length() != 4) {
            get_userid.requestFocus();
            get_userid.setError("USER_ID Must Contain 4 Didits !!!");
            get_userid.setText(null);
        } else if (!pwdValid(password)) {
            get_password.requestFocus();
            get_password.setError("Invalid Password !!!");
            Toast.makeText(getBaseContext(), "Password Must be Min. 6 And Max. 16 Letter Long !!!\n" +
                    "Password Must be Consist Of Min. 1 Upper-Case and Min. 1 Lower-Case Letter With Min. 1 Digit And Min. 1 Special Character !!!", Toast.LENGTH_LONG).show();
            get_password.setText(null);
            get_reset_password.setText(null);
        } else if (!(password).equals(reset_password)) {
            get_reset_password.requestFocus();
            get_reset_password.setError("Previously entered password and this password does not match !!!");
            get_reset_password.setText(null);
        } else {
            new_registartion = new New_Registartion(context);
            sqLiteDatabase = new_registartion.getWritableDatabase();
            new_registartion.addInformation(name, id, password, sqLiteDatabase);
            Toast.makeText(getBaseContext(), "Registration Successfully Done !!!", Toast.LENGTH_LONG).show();
            new_registartion.close();
        }
    }

    public void onResetClick(View v){

        get_username.setText(null);
        get_userid.setText(null);
        get_password.setText(null);
        get_reset_password.setText(null);
    }

    private boolean pwdValid(String password){

        String PWD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,16})";
        Pattern pattern = Pattern.compile(PWD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
