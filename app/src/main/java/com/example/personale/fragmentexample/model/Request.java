package com.example.personale.fragmentexample.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by personale on 07/04/2017.
 */

public class Request{

    int id, idBook;
    String url;

    public Request(JSONObject o){
        try {
            id = o.optInt("ID");
            idBook = o.optInt("IDBook");
            url = o.getString("Url");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public Request setId(int id) {
        this.id = id;
        return this;
    }

    public int getIdBook() {
        return idBook;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "id: " + id + " - idBook: " + idBook + " - url: " + url + "\n";
    }
}
