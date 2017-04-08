package com.example.personale.fragmentexample.dataset;

import com.example.personale.fragmentexample.model.Position;

import java.util.ArrayList;

/**
 * Created by personale on 05/04/2017.
 */

public class ListPosition {
    private ArrayList<Position> list;

    public ListPosition(){
        initialize();
    }

    private void initialize() {
        if(list == null){
            list = new ArrayList<>();
        }
    }

    public void add(Position p){
        list.add(0, p);
    }

    public void set(int pos, Position p){
        list.set(pos, p);
    }

    public void remove(Position p){
        list.remove(p);
    }

    public ArrayList<Position> getList() {
        if(list != null){
            return new ArrayList<>(list);
        }

        return null;
    }

    public Position getByPos(int pos) {
        if(list != null){
            return list.get(pos);
        }

        return null;
    }

    public int getSize() {
        return list.size();
    }

    public void setDataSet(ArrayList<Position> list) {
        this.list = list;
    }
}
