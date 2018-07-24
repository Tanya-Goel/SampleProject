package com.example.tanya.sampleproject.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tanya.sampleproject.R;

import java.util.ArrayList;

public class NotificationAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> items;

    public NotificationAdapter(Context context) {
        this.context = context;
        items=new ArrayList<>();
        items.add("TANYA");
        items.add("RIYA");
        items.add("TANVI");
        items.add("TRISHA");
        items.add("Aastha");
        items.add("amyra");
        items.add("manya");
        items.add("amanaya");
    }

    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            view=View.inflate(context, R.layout.notification_layout,null);

        }
        ((TextView)view.findViewById(R.id.tv1)).setText(items.get(i%8)+" uploaded:");
        return view;
    }
}
