package com.example.tanya.sampleproject.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.tanya.sampleproject.adapters.NotificationAdapter;
import com.example.tanya.sampleproject.R;


/**
 * A simple {@link Fragment} subclass.
 */


public class Fragment_Notification extends Fragment {
ListView lv;

    public Fragment_Notification() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fragment__notification, container, false);
        lv=view.findViewById(R.id.lv2);
        NotificationAdapter adapter=new NotificationAdapter(getContext());
        lv.setAdapter(adapter);
        // Inflate the layout for this fragment
        return view;
    }

}
