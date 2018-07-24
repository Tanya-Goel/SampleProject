package com.example.tanya.sampleproject.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.tanya.sampleproject.others.Details;
import com.example.tanya.sampleproject.adapters.ListAdaptor_Youtube;
import com.example.tanya.sampleproject.R;

import java.util.ArrayList;

public class MyVideosActivity extends AppCompatActivity {
    ArrayList<Details> list = new ArrayList<>();

    ListView lv;
    ProgressBar pb;
    ListAdaptor_Youtube adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_videos);

        Toolbar toolbar = findViewById(R.id.tb1);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }
        lv = findViewById(R.id.lv);
        pb = findViewById(R.id.pb);
        adaptor = new ListAdaptor_Youtube(this);
        lv.setAdapter(adaptor);
    }

    //
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_fragment1_youtube, container, false);
//        lv = view.findViewById(R.id.lv1);
//        ListAdapter adapter = new ListAdaptor_Youtube(this);
//        lv.setAdapter(adapter);
//        return view;
//    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}