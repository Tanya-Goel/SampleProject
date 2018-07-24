package com.example.tanya.sampleproject.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tanya.sampleproject.R;
import com.example.tanya.sampleproject.activities.TapForVideo;
import com.example.tanya.sampleproject.others.YouTube_data;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class YouTubeDataAdapter extends BaseAdapter implements View.OnClickListener {
    Context context;
    ArrayList<YouTube_data> items;

    public YouTubeDataAdapter(Context context, ArrayList<YouTube_data> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
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
            view = View.inflate(context, R.layout.youtube_item, null);
        }
        YouTube_data youTube_data= items.get(i);
        ((TextView) view.findViewById(R.id.title_youtube)).setText(youTube_data.getTitle());

        ((TextView) view.findViewById(R.id.author_name_youtube)).setText(youTube_data.getAuthor_name());
       ImageView imageView = (ImageView) view.findViewById(R.id.idimg);
       Picasso.with(context).load(youTube_data.getURL()).into(imageView);
       view.setTag(i);
     view.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View view) {
        Intent intent=new Intent(context,TapForVideo.class);
        intent.putExtra("name",items.get(Integer.parseInt(view.getTag().toString())));
        context.startActivity(intent);


        }

    }


