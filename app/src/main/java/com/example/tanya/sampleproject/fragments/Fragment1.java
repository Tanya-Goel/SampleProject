package com.example.tanya.sampleproject.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {
    ListView lv;
    ArrayList<Details> list=new ArrayList<>();
    ListAdaptor adaptor;
    ProgressBar pb;

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        lv=view.findViewById(R.id.lv);
        pb=view.findViewById(R.id.pb);
        adaptor=new ListAdaptor(getContext(),list);
        lv.setAdapter(adaptor);
        getData();
        return view;
    }
    public void getData(){

        JsonArrayRequest request=new JsonArrayRequest( "https://api.androidhive.info/json/movies.json",
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        Log.i("Mainactivity", "onResponse: "+response);
                        for(int i=0;i<response.length();i++)
                        {
                            JSONObject O;

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

                Toast.makeText(getContext(),error.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
        AppController.getInstance().addToRequestQueue(request);

    }

}


