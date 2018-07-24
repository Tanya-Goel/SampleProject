package com.example.tanya.sampleproject.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.tanya.sampleproject.others.AppController;
import com.example.tanya.sampleproject.R;
import com.example.tanya.sampleproject.adapters.YouTubeDataAdapter;
import com.example.tanya.sampleproject.others.YouTube_data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Youtube extends Fragment {
    ListView lv;
    ArrayList<YouTube_data> items = new ArrayList<>();
    YouTubeDataAdapter adapter;

    public Fragment_Youtube() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view=  inflater.inflate(R.layout.fragment_fragment1_youtube, container, false);
        lv=view.findViewById(R.id.lv1);
        adapter=new YouTubeDataAdapter(getContext(),items);
        lv.setAdapter(adapter);
        getData();
        return view;
    }
    public void getData()
    {
        JsonArrayRequest request=new JsonArrayRequest("https://api.myjson.com/bins/f8gda", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                Log.i("Myapp","Response is "+response);
                for(int i=0;i<response.length();i++)
                {
                    try {
                        JSONObject o = response.getJSONObject(i);
                        String Title=o.getString("title");
                        String Author_name=o.getString("author_name");
                        String URL=o.getString("thumbnail_url");
                        items.add(new YouTube_data(Title, URL,Author_name));


                    } catch (JSONException e) {
                        e.printStackTrace();

                    }

                }

                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),"Some Error Ocurred",Toast.LENGTH_SHORT).show();
            }
        });

        AppController.getInstance().addToRequestQueue(request);
    }

}
