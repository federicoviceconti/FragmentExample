package com.example.personale.fragmentexample.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.personale.fragmentexample.R;
import com.example.personale.fragmentexample.adapter.AdapterPosition;
import com.example.personale.fragmentexample.model.Position;

/**
 * Created by personale on 05/04/2017.
 */

public class ListFragment extends Fragment implements View.OnClickListener {

    private RecyclerView recyclerPositionList;
    private AdapterPosition adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        initialize(v);
        return v;
    }

    private void initialize(View v) {
        recyclerPositionList = (RecyclerView) v.findViewById(R.id.recycler_list);
        recyclerPositionList.setLayoutManager(new LinearLayoutManager(v.getContext()));
        recyclerPositionList.setHasFixedSize(true);

        adapter = ((MainActivity) v.getContext()).getAdapterPosition();
        recyclerPositionList.setAdapter(adapter);

        v.findViewById(R.id.fab_add).setOnClickListener(this);
        getActivity().setTitle("Fragment Maps");

        if (((MainActivity) getActivity()).getMenu() != null) {
            ((MainActivity) getActivity()).getMenu().getItem(0).setVisible(true);
        }
    }

    @Override
    public void onClick(final View v) {
        final View toInflate = getActivity().getLayoutInflater().inflate(R.layout.fragment_add, null);

        AlertDialog.Builder addDialog = new AlertDialog.Builder(getActivity());
        addDialog
                .setView(toInflate)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText etX = (EditText) toInflate.findViewById(R.id.add_x);
                        EditText etY = (EditText) toInflate.findViewById(R.id.add_y);

                        if (!etX.getText().toString().isEmpty() || !etY.toString().isEmpty()) {
                            adapter.add(new Position.PositionBuilder()
                                    .set_x(Double.parseDouble(etX.getText().toString()))
                                    .set_y(Double.parseDouble(etY.getText().toString()))
                                    .build());

                            recyclerPositionList.scrollToPosition(0);
                        }
                    }
                })
                .create()
                .show();
    }
}