package com.example.personale.fragmentexample.dataset;

import com.example.personale.fragmentexample.model.Request;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by personale on 07/04/2017.
 */

public class RequestPosition{
    private List<Request> list;

    public RequestPosition(){
        initialize();
    }

    private void initialize() {
        if(list == null){
            list = new ArrayList<>();
        }
    }

    public void add(Request r){
        list.add(0, r);
    }

    public void set(int pos, Request r){
        list.set(pos, r);
    }

    public void remove(Request r){
        list.remove(r);
    }

    public ArrayList<Request> getList() {
        if(list != null){
            return new ArrayList<>(list);
        }

        return null;
    }

    public Request getByPos(int pos) {
        if(list != null){
            return list.get(pos);
        }

        return null;
    }

    public int getSize() {
        return list.size();
    }

    public void setDataSet(List<Request> list) {
        this.list = list;
    }
}
