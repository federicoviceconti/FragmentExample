package com.example.personale.fragmentexample.utilities;

import android.content.Context;
import android.os.AsyncTask;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.personale.fragmentexample.activities.MainActivity;
import com.example.personale.fragmentexample.model.Request;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by personale on 07/04/2017.
 */

public class InfoRequest extends AsyncTask<String, Void, Void> {

    private final Context context;

    public InfoRequest(Context context){
        this.context = context;
    }

    @Override
    protected Void doInBackground(String... params) {
        final RequestQueue req = Volley.newRequestQueue(context);

        JsonArrayRequest arrayBook = new JsonArrayRequest(params[0], new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    List<Request> list = new ArrayList<>();

                    for(int i = 0; i < response.length(); i++){
                        list.add(new Request(response.getJSONObject(i)));
                    }

                    ((MainActivity) context).getAdapterRequest().setDataSet(list);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        req.add(arrayBook);

        return null;
    }

}
