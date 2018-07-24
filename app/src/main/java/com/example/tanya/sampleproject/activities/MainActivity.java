package com.example.tanya.sampleproject.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.tanya.sampleproject.fragments.Fragment1;
import com.example.tanya.sampleproject.fragments.FragmentActivity;
import com.example.tanya.sampleproject.fragments.Fragment_Youtube;
import com.example.tanya.sampleproject.fragments.Library_Fragment;
import com.example.tanya.sampleproject.R;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
BottomNavigationView btv;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.drawable.ic_live_tv);


        btv=findViewById(R.id.bnv);
        btv.setOnNavigationItemSelectedListener(this);
         fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        Fragment_Youtube fragment_youtube=new Fragment_Youtube();
        transaction.add(R.id.fc,fragment_youtube);
        transaction.commit();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        FragmentTransaction transaction=fragmentManager.beginTransaction();

        switch (menuItem.getItemId()){
            case R.id.i1:
                Fragment_Youtube fragment_youtube=new Fragment_Youtube();
                transaction.replace(R.id.fc,fragment_youtube);
                transaction.commit();
                return true;
            case R.id.i2:
                Fragment1 fragment1=new Fragment1();
                transaction.replace(R.id.fc,fragment1);
                transaction.commit();
                break;
            case R.id.i3:
                //
              break;
            case R.id.i4:
                FragmentActivity fragmentActivity=new FragmentActivity();
                transaction.replace(R.id.fc,fragmentActivity);
                transaction.commit();

                break;
            case R.id.i5:
                Library_Fragment library_fragment=new Library_Fragment();
                transaction.replace(R.id.fc,library_fragment);
                transaction.commit();

                break;
                }
        return true;
    }
}
