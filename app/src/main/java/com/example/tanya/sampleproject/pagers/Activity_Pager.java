package com.example.tanya.sampleproject.pagers;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.tanya.sampleproject.fragments.Fragment_Notification;
import com.example.tanya.sampleproject.fragments.Fragment_Shared;

public class Activity_Pager extends FragmentPagerAdapter {
    public Activity_Pager(FragmentManager fm)  {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
       if(i==0) {

           return new Fragment_Shared();
       }
           else
           {
               return new Fragment_Notification();

       }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "Shared";


        }
        else{
            return "Notification";
        }
    }
}
