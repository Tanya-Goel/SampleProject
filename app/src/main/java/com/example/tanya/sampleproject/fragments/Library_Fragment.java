package com.example.tanya.sampleproject.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.tanya.sampleproject.R;
import com.example.tanya.sampleproject.activities.HistoryActivity;
import com.example.tanya.sampleproject.activities.MyVideosActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class Library_Fragment extends Fragment {
    LinearLayout lv;


    public Library_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_library, container, false);
        lv=view.findViewById(R.id.lv3);

        view.findViewById(R.id.history).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Opening History",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(),HistoryActivity.class));
            }
        });
        view.findViewById(R.id.myvideos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Opening My Videos", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(),MyVideosActivity.class));
                                                                }
                                                            }
        );





        for(int i=0;i<10;i++)
        {
            LinearLayout.LayoutParams l = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            View v = View.inflate(getContext(),R.layout.playlist_layout,null);
            v.setLayoutParams(l);
            lv.addView(v);
        }

        LinearLayout.LayoutParams l = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        View v = View.inflate(getContext(),R.layout.liked_layout,null);
      //  v.setLayoutParams(l);
        lv.addView(v);

        // Inflate the layout for this fragment
        return view;
    }

}
