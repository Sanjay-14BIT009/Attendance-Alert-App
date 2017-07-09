package com.example.bublly.android_app_attendence_alerts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by BUBLLY on 25-02-2016.
 */
public class New_Registartion extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "New_Register_Info";
    private static final int DATABASE_VERSION = 1;
   /* public static final String USER_NAME = "user_name";
    public static final String USER_ID = "user_id";
    public static final String PASSWORD = "password";
    public static final String TABLE_NAME= "registation_table";*/

    private static final String CREATE_QUERY =
      "CREATE TABLE "+UserContract.new_registration_info.TABLE_NAME+"("+UserContract.new_registration_info.USER_NAME+" TEXT,"+
              UserContract.new_registration_info.USER_ID+" TEXT,"+UserContract.new_registration_info.PASSWORD+" TEXT);";

    New_Registartion new_registartion;
    SQLiteDatabase sqLiteDatabase;

    public New_Registartion(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS","REGISTRATION DATABASE CREATED / OPENED !!!");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS", "NEW REGISTRATION DATABASE CREATED !!!");
    }

    public void addInformation(String name,String id,String password,SQLiteDatabase db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContract.new_registration_info.USER_NAME,name);
        contentValues.put(UserContract.new_registration_info.USER_ID,id);
        contentValues.put(UserContract.new_registration_info.PASSWORD, password);
        db.insert(UserContract.new_registration_info.TABLE_NAME, null, contentValues);
        Log.e("DATABASE OPERATIONS", "NEW REGISTRATION SUCCESSFULLY DONE !!!");
    }

    public String verifyInformation(String username)
    {
        sqLiteDatabase = this.getReadableDatabase();
        String query = "select user_name, password from "+UserContract.new_registration_info.TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        String a,b;
        b = "User Name Not Found !!";

        if(cursor.moveToFirst())
        {
            do {
                    a = cursor.getString(0);
                    if(a.equals(username))
                    {
                        b = cursor.getString(1);
                        break;
                    }
              }while (cursor.moveToNext());
        }
        return  b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
