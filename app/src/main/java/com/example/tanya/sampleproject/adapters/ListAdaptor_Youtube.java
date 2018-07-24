package com.example.tanya.sampleproject.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.tanya.sampleproject.R;

import java.util.ArrayList;

public class ListAdaptor_Youtube extends BaseAdapter implements View.OnClickListener {
    Context context;

    ArrayList<String> people;



    public ListAdaptor_Youtube(Context context) {
        this.context = context;
        people=new ArrayList<>();
        people.add("TANYA");
        people.add("RIYA");
        people.add("TANVI");
        people.add("TRISHA");
        people.add("ABS");
        people.add("ADS");
        people.add("DSFDSFS");
        people.add("dsffsdgsd");
    }

    @Override
    public int getCount() {
        return 500;
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
        if(view == null)
        {
            view = View.inflate(context, R.layout.list,null);
        }
        ((TextView)view.findViewById(R.id.tv1)).setText(people.get(i%8));
        ((ImageView)view.findViewById(R.id.popup)).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        PopupMenu menu=new PopupMenu(context,view);
        menu.getMenuInflater().inflate(R.menu.additems,menu.getMenu());
        menu.show();

    }
}
