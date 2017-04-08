package com.example.personale.fragmentexample.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.personale.fragmentexample.R;
import com.example.personale.fragmentexample.utilities.Field;
import com.example.personale.fragmentexample.utilities.Utility;

import petrov.kristiyan.colorpicker.ColorPicker;

/**
 * Created by personale on 06/04/2017.
 */

public class SettingFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_setting, container, false);
        v.findViewById(R.id.btn_primary).setOnClickListener(this);
        v.findViewById(R.id.btn_dark).setOnClickListener(this);

        getActivity().setTitle("Setting");
        Utility.disableMenu(getActivity());
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_primary:
                buildColorPicker(Field.TYPE_PRIMARY).show();
                break;
            case R.id.btn_dark:
                buildColorPicker(Field.TYPE_DARK).show();
                break;
        }
    }

    public ColorPicker buildColorPicker(final String type) {
        return new ColorPicker(getActivity()).setOnFastChooseColorListener(new ColorPicker.OnFastChooseColorListener() {
            @Override
            public void setOnFastChooseColorListener(int position, int color) {
                savePreferences(type, color);
            }

            @Override
            public void onCancel() {

            }
        }).setColumns(5);
    }

    public void savePreferences(String type, int color) {
        SharedPreferences.Editor editor = getActivity()
                .getSharedPreferences(getString(R.string.preferences), Context.MODE_PRIVATE)
                .edit();

        switch (type) {
            case Field.TYPE_PRIMARY:
                Utility.setStatusBar(getActivity(), color);
                editor.putInt(getString(R.string.preferences_primary), color);
                break;
            case Field.TYPE_DARK:
                Utility.setToolbar(((AppCompatActivity)getActivity()).getSupportActionBar(), color);
                editor.putInt(getString(R.string.preferences_dark), color);
                break;
        }

        editor.apply();
    }
}
