package com.example.tanya.sampleproject.activities;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.tanya.sampleproject.R;
import com.example.tanya.sampleproject.others.YouTube_data;
import com.squareup.picasso.Picasso;

public class TapForVideo extends AppCompatActivity {
    VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap_for_video);
        YouTube_data data=getIntent().getParcelableExtra("name");
        ((TextView)findViewById(R.id.title_youtube)).setText(data.getTitle());
        ((TextView)findViewById(R.id.author_name_youtube)).setText(data.getAuthor_name());

        vv=findViewById(R.id.vv);
        vv.setVideoURI(Uri.parse("https://translate.google.com.vn/translate_tts?ie=UTF-8&q=Hi+There&tl=hi&client=tw-ob"));
        vv.setMediaController(new MediaController(this));
        vv.start();


    }
}
