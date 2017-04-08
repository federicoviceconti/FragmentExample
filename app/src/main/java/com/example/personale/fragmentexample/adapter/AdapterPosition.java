package com.example.personale.fragmentexample.adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.personale.fragmentexample.R;
import com.example.personale.fragmentexample.activities.MainActivity;
import com.example.personale.fragmentexample.activities.MapsFragment;
import com.example.personale.fragmentexample.dataset.ListPosition;
import com.example.personale.fragmentexample.model.Position;

import java.util.ArrayList;

/**
 * Created by personale on 05/04/2017.
 */

public class AdapterPosition extends RecyclerView.Adapter<AdapterPosition.PositionVH> {
    private final FragmentActivity activity;
    private ListPosition dataSet;

    public AdapterPosition(FragmentActivity activity){
        this.activity = activity;
        dataSet = new ListPosition();
    }

    @Override
    public PositionVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PositionVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false));
    }

    @Override
    public void onBindViewHolder(PositionVH holder, int position) {
        Position p = dataSet.getByPos(position);

        holder.xTv.setText(String.valueOf(p.getX()));
        holder.yTv.setText(String.valueOf(p.getY()));
    }

    @Override
    public int getItemCount() {
        return dataSet.getSize();
    }

    public void add(Position p) {
        dataSet.add(p);
        notifyItemInserted(0);
    }

    class PositionVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView xTv, yTv;
        Button btnOk;

        PositionVH(View itemView) {
            super(itemView);

            xTv = (TextView) itemView.findViewById(R.id.x_value);
            yTv = (TextView) itemView.findViewById(R.id.y_value);
            btnOk = (Button) itemView.findViewById(R.id.button);
            btnOk.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            activity.getSupportFragmentManager().beginTransaction()
                    .addToBackStack("Maps")
                    .replace(R.id.container, new MapsFragment()).commit();
            ((MainActivity)itemView.getContext()).setDataX(dataSet.getByPos(getAdapterPosition()).getX());
            ((MainActivity)itemView.getContext()).setDataY(dataSet.getByPos(getAdapterPosition()).getY());
        }
    }
}
