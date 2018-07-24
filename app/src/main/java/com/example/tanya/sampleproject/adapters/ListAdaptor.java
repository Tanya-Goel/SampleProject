package com.example.tanya.sampleproject.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tanya.sampleproject.others.Details;
import com.example.tanya.sampleproject.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListAdaptor extends BaseAdapter {
    Context context;
    ArrayList<Details> list;


    public ListAdaptor(Context context, ArrayList<Details> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
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
        if (view == null) {
            view = View.inflate(context, R.layout.listitem, null);
        }
        Details details = list.get(i);
        ((TextView) view.findViewById(R.id.tv1)).setText(details.getTitle());
        ((TextView) view.findViewById(R.id.tv2)).setText("Rating: " + details.getRating());
        ((TextView) view.findViewById(R.id.tv3)).setText(String.valueOf(details.getYear()));
        ((TextView) view.findViewById(R.id.tv4)).setText(details.getGenre());

        ImageView imageView = view.findViewById(R.id.thumbnail);
//        Picasso.with(context).load(details.getURL()).into(imageView);
//        Picasso.with(context).load(details.getURL()).fit().centerCrop()
//                .placeholder(R.drawable.ic_2)
//                .error(R.drawable.ic1)
//                .into(imageView);
        Picasso.with(context).load(details.getURL()).placeholder(R.drawable.ic_2).
                resize(100, 100).into(imageView);
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.listener(new Picasso.Listener() {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                exception.printStackTrace();
            }
        });

        return view;

    }
}