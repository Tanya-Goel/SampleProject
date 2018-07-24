package com.example.tanya.sampleproject.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tanya.sampleproject.R;
import com.example.tanya.sampleproject.pagers.Activity_Pager;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentActivity extends Fragment {


    public FragmentActivity() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_, container, false);
        TabLayout tabLayout=view.findViewById(R.id.tl);
        ViewPager viewPager=view.findViewById(R.id.vp);
        Activity_Pager pager=new Activity_Pager(getChildFragmentManager());
        viewPager.setAdapter(pager);
        tabLayout.setupWithViewPager(viewPager);
        return view;


    }

}
