package com.example.personale.fragmentexample.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.personale.fragmentexample.R;
import com.example.personale.fragmentexample.adapter.AdapterPosition;
import com.example.personale.fragmentexample.adapter.AdapterRequest;
import com.example.personale.fragmentexample.model.Request;
import com.example.personale.fragmentexample.utilities.InfoRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by personale on 06/04/2017.
 */

public class RequestFragment extends Fragment{

    private static final String url = "http://fakerestapi.azurewebsites.net/api/CoverPhotos";
    private RecyclerView recyclerPositionList;
    private AdapterRequest adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_api, container, false);
        initialize(v);
        return v;
    }

    private void initialize(View v) {
        recyclerPositionList = (RecyclerView) v.findViewById(R.id.recycler_list);
        recyclerPositionList.setLayoutManager(new LinearLayoutManager(v.getContext()));
        recyclerPositionList.setHasFixedSize(true);

        adapter = ((MainActivity)v.getContext()).getAdapterRequest();
        recyclerPositionList.setAdapter(adapter);
        getActivity().setTitle("Fragment Maps");

        if(((MainActivity)getActivity()).getMenu() != null){
            ((MainActivity)getActivity()).getMenu().getItem(0).setVisible(true);
        }

        loadDataFromUrl();
    }

    private void loadDataFromUrl(){
        new InfoRequest(getActivity()).execute(url);
    }
}
