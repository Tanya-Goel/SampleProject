package com.example.tanya.sampleproject.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tanya.sampleproject.R;

import java.util.ArrayList;

public class SharedAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> values;

    public SharedAdapter(Context context) {
        this.context = context;
        values=new ArrayList<>();
        values.add("TANYA");
        values.add("RIYA");
        values.add("TANVI");
        values.add("TRISHA");
        values.add("ABS");
        values.add("ADS");
        values.add("DSFDSFS");
        values.add("dsffsdgsd");
    }

    @Override

    public int getCount() {
        return values.size();
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
            view=View.inflate(context, R.layout.shared_layout,null);
        }
        ((TextView)view.findViewById(R.id.tv1)).setText(values.get(i));
        return view;
    }
}
