package com.example.personale.fragmentexample.adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.personale.fragmentexample.R;
import com.example.personale.fragmentexample.dataset.RequestPosition;
import com.example.personale.fragmentexample.model.Request;

import java.util.List;

/**
 * Created by personale on 06/04/2017.
 */

public class AdapterRequest extends RecyclerView.Adapter<AdapterRequest.RequestVH> {
    private final FragmentActivity activity;
    private RequestPosition dataSet;

    public AdapterRequest(FragmentActivity activity){
        this.activity = activity;
        dataSet = new RequestPosition();
    }

    @Override
    public AdapterRequest.RequestVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AdapterRequest.RequestVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_request, parent, false));
    }

    @Override
    public void onBindViewHolder(AdapterRequest.RequestVH holder, int position) {
        Request r = dataSet.getByPos(position);

        holder.title.setText(String.valueOf(r.getId()));
        holder.description.setText(String.valueOf(r.getIdBook()));

        Glide.with(activity.getBaseContext())
                .load(r.getUrl())
                .into(holder.image);
    }

    public void setDataSet(List<Request> dataSet){
        this.dataSet.setDataSet(dataSet);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataSet.getSize();
    }

    class RequestVH extends RecyclerView.ViewHolder {
        TextView title, description;
        ImageView image;

        RequestVH(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.title);
            description = (TextView)itemView.findViewById(R.id.description);
            image = (ImageView) itemView.findViewById(R.id.image);
        }

    }
}
