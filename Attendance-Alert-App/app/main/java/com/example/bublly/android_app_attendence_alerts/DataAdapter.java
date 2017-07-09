package com.example.bublly.android_app_attendence_alerts;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BUBLLY on 07-04-2016.
 */
public class DataAdapter extends ArrayAdapter {

    List list =new ArrayList();
    public DataAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(Object object)
    {
        super.add(object);
        list.add(object);
    }

    public int getCount()
    {
        return list.size();
    }

    public Object getItem(int position)
    {
        return list.get(position);
    }

    public View getView(int position,View convertView,ViewGroup parent)
    {
        return super.getView(position,convertView,parent);
    }
}
