package com.example.tanya.sampleproject.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.tanya.sampleproject.others.AppController;
import com.example.tanya.sampleproject.others.Details;
import com.example.tanya.sampleproject.adapters.ListAdaptor;
import com.example.tanya.sampleproject.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    ArrayList<Details> list=new ArrayList<>();
    ListAdaptor adaptor;
    ProgressBar pb;
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Toolbar toolbar= findViewById(R.id.tb);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        lv = findViewById(R.id.lv);
        pb = findViewById(R.id.pb);
        adaptor = new ListAdaptor(this, list);
        lv.setAdapter(adaptor);
        getData();
    }
    public void getData(){

        JsonArrayRequest request=new JsonArrayRequest( "https://api.androidhive.info/json/movies.json",
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        Log.i("Mainactivity", "onResponse: "+response);
                        for(int i=0;i<response.length();i++)
                        {
                            JSONObject O= null;
                            try {
                                O = response.getJSONObject(i);
                                String title=O.getString("title");
                                String URL=O.getString("image");
                                int rating=O.getInt("rating");
                                int year=O.getInt("releaseYear");
                                JSONArray array=O.getJSONArray("genre");
                                String s=" ";
                                for(int j=0;j<array.length();j++){
                                    if(j==0) {
                                        s += array.getString(j);
                                    }
                                    else{
                                        s += ","+array.getString(j);
                                    }
                                }
                                Details details=new Details(title,rating,year,s,URL);
                                list.add(details);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        adaptor.notifyDataSetChanged();
                        pb.setVisibility(View.GONE);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HistoryActivity.this,error.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
        AppController.getInstance().addToRequestQueue(request);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}



